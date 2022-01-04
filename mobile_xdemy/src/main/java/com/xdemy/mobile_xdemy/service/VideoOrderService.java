package com.xdemy.mobile_xdemy.service;

import com.xdemy.mobile_xdemy.model.entity.VideoOrder;

import java.util.List;

public interface VideoOrderService {

    int createOrder(int userId, int videoId);

    List<VideoOrder> findAllVideosByUserId(Integer userId);
}
