package com.example.css699.controllers;

import com.example.css699.models.User;
import com.example.css699.models.Video;
import com.example.css699.models.VideoWithData;
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
    @CrossOrigin(origins="http://localhost:4200")
    public Video uploadVideo(@RequestParam("videoFile") MultipartFile videoFile) throws IOException {
        return videoService.saveVideoToFolder(videoFile);
    }

    @PostMapping("/saveVideo")
    @CrossOrigin(origins="http://localhost:4200")
    public Video saveVideo(@RequestBody Video video){
            return videoService.saveVideo(video);
    }

    @GetMapping("/allVideos")
    @CrossOrigin(origins="http://localhost:4200")
    public List<Video> getAllVideos(){
        return videoService.getAllVideos();
    }

    @GetMapping("/pending")
    @CrossOrigin(origins="http://localhost:4200")
    public List<Video> getAllVPendingVideos(){
        return videoService.getAllVPendingVideos();
    }

    @GetMapping("/myVideos/{userName}")
    @CrossOrigin(origins="http://localhost:4200")
    public List<Video> getMyVideos(@PathVariable String userName){
        return videoService.getMyVideos(userName);
    }

    @GetMapping("/videoByVidId/{vidId}")
    @CrossOrigin(origins="http://localhost:4200")
    public VideoWithData getVideoByVideoId(@PathVariable int vidId) throws IOException {
        return videoService.getVideoByVideoId(vidId);
    }

    @GetMapping("/getCreatorNameFromCreatorId/{creatorId}")
    @CrossOrigin(origins="http://localhost:4200")
    public User getCreatorNameFromCreatorId(@PathVariable int creatorId){
        return videoService.getCreatorNameFromCreatorId(creatorId);
    }

    @PutMapping("/likeAVideo")
    @CrossOrigin(origins="http://localhost:4200")
    public int likeAVideo(@RequestBody int vidId){
        return videoService.likeAVideo(vidId);
    }


}
