package com.example.css699.rowmapper;

import com.example.css699.models.User;
import com.example.css699.models.Video;
import com.example.css699.models.VideoWithData;
import org.springframework.jdbc.core.RowMapper;

public class VideoRowMapper {


    public VideoRowMapper() {
    }

    public static final RowMapper<Video> lambda = (record, recordNumber) -> {
        Video video = new Video();
        video.setVidName(record.getString("vidName"));
        video.setVidDescription(record.getString("vidDescription"));
        video.setCreator(record.getInt("creatorId"));
        video.setVidPath(record.getString("vidPath"));
        video.setVidId(record.getInt("vidId"));
        video.setUploadedOn(record.getDate("uploadedOn"));
        video.setStatus(record.getString("status"));
        return video;
    };
    public static final RowMapper<VideoWithData> lambdaWithData = (record, recordNumber) -> {
        VideoWithData video = new VideoWithData();
        video.setVidName(record.getString("vidName"));
        video.setVidDescription(record.getString("vidDescription"));
        video.setCreator(record.getInt("creatorId"));
        video.setVidPath(record.getString("vidPath"));
        video.setVidId(record.getInt("vidId"));
        video.setUploadedOn(record.getDate("uploadedOn"));
        video.setStatus(record.getString("status"));
        video.setLikes(record.getInt("likes"));
        return video;
    };


}
