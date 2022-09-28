package com.example.css699.controllers;

import com.example.css699.models.Video;
import com.example.css699.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    @Autowired
     private VideoService videoService;

    @PostMapping("/uploadVideo")
    public Video uploadVideo(Video video){
        return videoService.uploadVideo(video);
    }

}
