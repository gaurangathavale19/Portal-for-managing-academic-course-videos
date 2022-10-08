package com.example.css699.controllers;

import com.example.css699.models.Video;
import com.example.css699.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class VideoController {

    @Autowired
     private VideoService videoService;

    @PostMapping("/uploadVideo")
    public Video uploadVideo(@RequestParam("videoFile") MultipartFile videoFile) throws IOException {
        return videoService.saveVideoToFolder(videoFile);
    }

    @PostMapping("/saveVideo")
    public Video saveVideo(@RequestBody Video video){
            return videoService.saveVideo(video);
    }

    @GetMapping("/allVideos")
    public List<Video> getAllVideos(){
        return videoService.getAllVideos();
    }

    @GetMapping("/pending")
    public List<Video> getAllVPendingVideos(){
        return videoService.getAllVPendingVideos();
    }

}
