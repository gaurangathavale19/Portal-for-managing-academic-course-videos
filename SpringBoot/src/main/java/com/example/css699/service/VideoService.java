package com.example.css699.service;

import com.example.css699.models.Video;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    public Video uploadVideo(Video video);

    public Video saveVideoToFolder(MultipartFile videoFile) throws IOException;

    public Video saveVideo(Video video);

    public List<Video> getAllVideos();

    public List<Video> getAllVPendingVideos();

}
