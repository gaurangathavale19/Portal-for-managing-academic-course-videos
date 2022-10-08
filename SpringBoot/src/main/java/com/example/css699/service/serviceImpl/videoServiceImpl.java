package com.example.css699.service.serviceImpl;

import com.example.css699.dao.VideoDao;
import com.example.css699.models.Video;
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

    public Video uploadVideo(Video video){
        return videoDao.uploadVideo(video);
    }

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

}
