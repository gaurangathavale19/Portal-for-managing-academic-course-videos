package com.example.css699.dao;

import com.example.css699.models.Video;
import com.example.css699.queries.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VideoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Video uploadVideo(Video video){
        jdbcTemplate.update(Queries.UPLOAD_VIDEO, video.getVidName(), video.getVidDescription(), video.getVidPath(), video.isApproved(), video.getUploadedOn());
        System.out.println("Uploaded the video");
        return video;
    }

}
