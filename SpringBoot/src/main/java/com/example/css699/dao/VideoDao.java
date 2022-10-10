package com.example.css699.dao;

import com.example.css699.models.User;
import com.example.css699.models.Video;
import com.example.css699.models.VideoWithData;
import com.example.css699.queries.Queries;
import com.example.css699.rowmapper.UserRowMapper;
import com.example.css699.rowmapper.VideoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Repository
public class VideoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Video uploadVideo(Video video){
        jdbcTemplate.update(Queries.UPLOAD_VIDEO, video.getVidName(), video.getVidDescription(), video.getVidPath(), video.getUploadedOn());
        System.out.println("Uploaded the video");
        return video;
    }

    public Video saveVideoToFolder(MultipartFile videoFile) throws IOException {
        Video video = new Video();
        Path path = Paths.get("uploads");
        if(!Files.exists(path)){
            Files.createDirectories(Paths.get("uploads"));
        }
        String fileName = videoFile.getOriginalFilename();
        int index = fileName.indexOf(".");
        Date date = new Date();
        String name = fileName.substring(0, index) + date.getTime() + fileName.substring(index);
        Files.copy(videoFile.getInputStream(), path.resolve(name));
        video.setVidPath(path.resolve(name).toString());
        video.setUploadedOn(new Date(System.currentTimeMillis()));
        jdbcTemplate.update(Queries.UPLOAD_VIDEO, video.getVidPath());
        video.setVidId(jdbcTemplate.query(Queries.GET_VIDEO_BY_PATH_NAME, VideoRowMapper.lambda, path.resolve(name).toString()).get(0).getVidId());
        return video;
    }

    public Video saveVideo(Video video){
        jdbcTemplate.update(Queries.UPDATE_VIDEO_DATA, video.getVidName(), video.getVidDescription(), video.getVidId());
        return video;
    }

    public List<Video> getAllVideos(){
        return jdbcTemplate.query(Queries.GET_ALL_APPROVED_VIDEOS, VideoRowMapper.lambda);
    }

    public List<Video> getAllVPendingVideos(){
        return jdbcTemplate.query(Queries.GET_ALL_PENDING_VIDEOS, VideoRowMapper.lambda);
    }

    public List<Video> getMyVideos(String userName){
        return jdbcTemplate.query(Queries.GET_MY_VIDEOS, VideoRowMapper.lambda , userName);
    }

    public VideoWithData getVideoByVideoId(int vidId) throws IOException {
        VideoWithData videoWithData = jdbcTemplate.queryForObject(Queries.GET_VIDEO_BY_VIDEO_ID, VideoRowMapper.lambdaWithData, vidId);
        File videoFile = new File(videoWithData.getVidPath());
        FileInputStream fileInputStream = new FileInputStream(videoFile);
        byte[] videoContent = new byte[(int) videoFile.length()];
        fileInputStream.read(videoContent);
        videoWithData.setData(Base64.getEncoder().encodeToString(videoContent));
        return videoWithData;
    }

    public User getCreatorNameFromCreatorId(int creatorId){
    return jdbcTemplate.queryForObject(Queries.GET_CREATOR_NAME_FROM_CREATOR_ID, UserRowMapper.lambda, creatorId);
    }

    public int likeAVideo(int vidId){
        return jdbcTemplate.update(Queries.LIKE_A_VIDEO, vidId);
    }

}
