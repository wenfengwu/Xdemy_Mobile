package com.xdemy.mobile_xdemy.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequest {

    @JsonProperty("video_id")
    private int videoId;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}
