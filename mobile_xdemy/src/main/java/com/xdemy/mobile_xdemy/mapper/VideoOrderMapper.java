package com.xdemy.mobile_xdemy.mapper;

import com.xdemy.mobile_xdemy.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoOrderMapper {
    //check if is the user has ordered the video and paid or not
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

    int createOrder(VideoOrder videoOrder);

    //get all purchased videos
    List<VideoOrder> findAllVideosByUserId(@Param("user_id") Integer userId);
}
