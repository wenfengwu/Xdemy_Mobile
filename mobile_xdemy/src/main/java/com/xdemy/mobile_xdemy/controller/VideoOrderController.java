package com.xdemy.mobile_xdemy.controller;

import com.xdemy.mobile_xdemy.model.entity.VideoOrder;
import com.xdemy.mobile_xdemy.model.request.OrderRequest;
import com.xdemy.mobile_xdemy.service.VideoOrderService;
import com.xdemy.mobile_xdemy.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/api/v1/pri/order")
@RestController
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;

    //HttpServletRequest, as same as HttpSession
    @RequestMapping("create")
    public JsonData createOrder(@RequestBody OrderRequest orderRequest, HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        int one = videoOrderService.createOrder(userId, orderRequest.getVideoId());
        return one == 0 ? JsonData.bulidError("order failed") : JsonData.bulidSuccess();
    }

    //get all purchased videos
    @GetMapping("list")
    public JsonData listOrder(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        List<VideoOrder> videoOrderList = videoOrderService.findAllVideosByUserId(userId);

        return JsonData.bulidSuccess(videoOrderList);
    }
}
