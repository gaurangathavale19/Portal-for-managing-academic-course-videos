package com.example.css699.rowmapper;

import com.example.css699.models.User;
import com.example.css699.models.Video;
import org.springframework.jdbc.core.RowMapper;

public class VideoRowMapper {


    public VideoRowMapper() {
    }

    public static final RowMapper<Video> lambda = (record, recordNumber) -> {
        Video video = new Video();
        video.setCreator(record.getInt("creatorId"));
        video.setVidPath(record.getString("vidPath"));
        video.setVidId(record.getInt("vidId"));

        return video;
    };

}
