package com.example.css699.service.serviceImpl;

import com.example.css699.dao.VideoDao;
import com.example.css699.models.User;
import com.example.css699.models.Video;
import com.example.css699.models.VideoWithData;
import com.example.css699.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class videoServiceImpl implements VideoService {


    @Autowired
    private VideoDao videoDao;

//    public Video uploadVideo(Video video){
//        return videoDao.uploadVideo(video);
//    }

    @Override
    public Video saveVideoToFolder(MultipartFile videoFile) throws IOException {
        return videoDao.saveVideoToFolder(videoFile);
    }

    @Override
    public Video saveVideo(Video video) {
        return videoDao.saveVideo(video);
    }

    @Override
    public List<Video> getAllVideos() {
        return videoDao.getAllVideos();
    }

    @Override
    public List<Video> getAllVPendingVideos() {
        return videoDao.getAllVPendingVideos();
    }

    @Override
    public List<Video> getMyVideos(String userName) {
        return videoDao.getMyVideos(userName);
    }

    @Override
    public VideoWithData getVideoByVideoId(int vidID) throws IOException {
        return videoDao.getVideoByVideoId(vidID);
    }

    @Override
    public User getCreatorNameFromCreatorId(int creatorId) {
        return videoDao.getCreatorNameFromCreatorId(creatorId);
    }

    @Override
    public int likeAVideo(int vidId) {
        return videoDao.likeAVideo(vidId);
    }

}
