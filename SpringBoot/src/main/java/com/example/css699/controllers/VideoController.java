package com.example.css699.controllers;

import com.example.css699.models.Like;
import com.example.css699.models.User;
import com.example.css699.models.Video;
import com.example.css699.models.VideoWithData;
import com.example.css699.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/** API **/
@RestController
public class VideoController {

    @Autowired
     private VideoService videoService;

    /** Upload video i.e. only the file **/
    @PostMapping("/uploadVideo")
    @CrossOrigin(origins="http://localhost:4200")
    public Video uploadVideo(@RequestParam("videoFile") MultipartFile videoFile) throws IOException {
        return videoService.saveVideoToFolder(videoFile);
    }

    /** Change the status on approval/rejection **/
    @PostMapping("/changeStatus/{vidID}/{status}")
    @CrossOrigin(origins="http://localhost:4200")
    public int setStatus(@PathVariable int vidID, @PathVariable String status){
        return videoService.changeStatus(vidID, status);
    }

    /** Save the video i.e. everything apart from video file **/
    @PostMapping("/saveVideo")
    @CrossOrigin(origins="http://localhost:4200")
    public Video saveVideo(@RequestBody Video video){
        System.out.println(video.getCreator());
        return videoService.saveVideo(video);
    }

    /** Get all the videos (Only Approved) **/
    @GetMapping("/allVideos")
    @CrossOrigin(origins="http://localhost:4200")
    public List<Video> getAllVideos(){
        return videoService.getAllVideos();
    }

    /** Get all pending videos for admins approval **/
    @GetMapping("/pending")
    @CrossOrigin(origins="http://localhost:4200")
    public List<Video> getAllVPendingVideos(){
        return videoService.getAllVPendingVideos();
    }

    /** Get the users video **/
    @GetMapping("/myVideos/{userName}")
    @CrossOrigin(origins="http://localhost:4200")
    public List<Video> getMyVideos(@PathVariable String userName){
        return videoService.getMyVideos(userName);
    }

    /** Get the video by video id **/
    @GetMapping("/videoByVidId/{vidId}")
    @CrossOrigin(origins="http://localhost:4200")
    public VideoWithData getVideoByVideoId(@PathVariable int vidId) throws IOException {
        return videoService.getVideoByVideoId(vidId);
    }

    /** Get the user name from user id **/
    @GetMapping("/getCreatorNameFromCreatorId/{creatorId}")
    @CrossOrigin(origins="http://localhost:4200")
    public User getCreatorNameFromCreatorId(@PathVariable int creatorId){
        return videoService.getCreatorNameFromCreatorId(creatorId);
    }

    /** Increment the like count on every like **/
    @PutMapping("/likeAVideo")
    @CrossOrigin(origins="http://localhost:4200")
    public int likeAVideo(@RequestBody int vidId){
        return videoService.likeAVideo(vidId);
    }

    /** Add the like to the like table (Explicit table to keep a track of which user liked which video) **/
    @PostMapping("/addALike")
    @CrossOrigin(origins = "http://localhost:4200")
    public Like addLike(@RequestBody Like like){
        return videoService.addALike(like);
    }

    /** Decrement the like count on every unlike **/
    @PutMapping("/unlikeAVideo")
    @CrossOrigin(origins="http://localhost:4200")
    public int unlikeAVideo(@RequestBody int vidId){
        return videoService.unlikeAVideo(vidId);
    }

    /** Remove the like from like table **/
    @PutMapping("/removeALike")
    @CrossOrigin(origins = "http://localhost:4200")
    public Like removeALike(@RequestBody Like like){
        return videoService.removeALike(like);
    }

    /** Check if a user has already liked the video **/
    @GetMapping("/checkIfVidLikedByUser/{userId}/{vidId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public int checkIfVidLikedByUser(@PathVariable int userId, @PathVariable int vidId){
        return videoService.checkIfVidLikedByUser(userId, vidId);
    }

    /** Edit video - Video title and video description **/
    @PostMapping("/editVideo")
    @CrossOrigin(origins = "http://localhost:4200")
    public int editVideo(@RequestBody Video video){
        return videoService.editVideo(video);
    }

    /** Delete video **/
    @PostMapping("/deleteVideo")
    @CrossOrigin(origins = "http://localhost:4200")
    public Video deleteVideo(@RequestBody Video video){
        return videoService.deleteVideo(video);
    }


}
