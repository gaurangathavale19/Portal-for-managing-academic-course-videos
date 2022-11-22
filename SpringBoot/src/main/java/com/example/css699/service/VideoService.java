package com.example.css699.service;

import com.example.css699.models.Like;
import com.example.css699.models.User;
import com.example.css699.models.Video;
import com.example.css699.models.VideoWithData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface VideoService {
//    public Video uploadVideo(Video video);

    public Video saveVideoToFolder(MultipartFile videoFile) throws IOException;

    public int changeStatus(int vidID, String status);

    public Video saveVideo(Video video);

    public List<Video> getAllVideos();

    public List<Video> getAllVPendingVideos();

    public List<Video> getMyVideos(String userName);

    public VideoWithData getVideoByVideoId(int vidID) throws IOException;

    public User getCreatorNameFromCreatorId(int creatorId);

    public int likeAVideo(int vidId);
    public Like addALike(Like like);

    public int unlikeAVideo(int vidId);
    public Like removeALike(Like like);
    public int checkIfVidLikedByUser(int userId, int vidId);
}
