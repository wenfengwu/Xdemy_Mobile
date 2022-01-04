package com.xdemy.mobile_xdemy.mapper;

import com.xdemy.mobile_xdemy.model.entity.Video;
import com.xdemy.mobile_xdemy.model.entity.VideoCarousel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {

    //All courses
    List<Video> listVideo();

    //All courses on carousel
    List<VideoCarousel> listVideoCarousel();

    //Course detail
    Video findVideoById(@Param("video_id") int videoId);

    //simply way to get course info
    Video findById(@Param("video_id") int videoId);
}
