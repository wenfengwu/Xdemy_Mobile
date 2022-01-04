package com.xdemy.mobile_xdemy.controller;

import com.xdemy.mobile_xdemy.model.entity.Video;
import com.xdemy.mobile_xdemy.model.entity.VideoCarousel;
import com.xdemy.mobile_xdemy.service.VideoService;
import com.xdemy.mobile_xdemy.utils.BaseCache;
import com.xdemy.mobile_xdemy.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;


    //get all carousel videos
    @GetMapping("list_carousel")
    public JsonData indexCarousel(){
        List<VideoCarousel> carouselList = videoService.listCarousel();
        return JsonData.bulidSuccess(carouselList);
    }

    //get all videos
    @GetMapping("list")
    public JsonData listVideo(){

        List<Video> videos = videoService.listVideo();

        return JsonData.bulidSuccess(videos);
    }

    @GetMapping("find_detail_by_id")
    public JsonData findVideoById(@RequestParam(value = "video_id", required = true) int videoId){
        Video video = videoService.findVideoById(videoId);
        return JsonData.bulidSuccess(video);
    }
}
