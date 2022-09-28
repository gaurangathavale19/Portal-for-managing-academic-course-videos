package com.example.css699.service.serviceImpl;

import com.example.css699.dao.VideoDao;
import com.example.css699.models.Video;
import com.example.css699.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class videoServiceImpl implements VideoService {


    @Autowired
    private VideoDao videoDao;

    public Video uploadVideo(Video video){
        return videoDao.uploadVideo(video);
    }

}
