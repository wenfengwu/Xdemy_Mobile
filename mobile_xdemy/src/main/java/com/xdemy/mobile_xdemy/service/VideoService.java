package com.xdemy.mobile_xdemy.service;

import com.xdemy.mobile_xdemy.model.entity.Video;
import com.xdemy.mobile_xdemy.model.entity.VideoCarousel;

import java.util.List;

public interface VideoService {

    List<Video> listVideo();

    List<VideoCarousel> listCarousel();

    Video findVideoById(int videoId);
}
