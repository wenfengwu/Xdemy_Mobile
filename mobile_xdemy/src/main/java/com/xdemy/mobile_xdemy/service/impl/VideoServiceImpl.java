package com.xdemy.mobile_xdemy.service.impl;

import com.xdemy.mobile_xdemy.config.CacheKey;
import com.xdemy.mobile_xdemy.mapper.VideoMapper;
import com.xdemy.mobile_xdemy.model.entity.Video;
import com.xdemy.mobile_xdemy.model.entity.VideoCarousel;
import com.xdemy.mobile_xdemy.service.VideoService;
import com.xdemy.mobile_xdemy.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {
        try{
            //find cache
            Object cacheObj =  baseCache.getTenMinuteCache().get(CacheKey.INDEX_VIDEOS_KEY,()->{
                List<Video> videoList = videoMapper.listVideo();
                System.out.println("get video data from database");
                return videoList;
            });

            //check if the cache we got is the right one
            if(cacheObj instanceof List){
                return (List<Video>)cacheObj;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<VideoCarousel> listCarousel() {

        try{
            //find cache
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKey.INDEX_CAROUSEL_KEY, () ->{
                List<VideoCarousel> carouselList = videoMapper.listVideoCarousel();
                System.out.println("find carousel from database");
                return carouselList;
            });

            //check if the cache we got is the right one
            if(cacheObj instanceof List){
                //cast the type to VideoCarousel
                return (List<VideoCarousel>)cacheObj;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findVideoById(int videoId) {

        //cast the videoId from int to String then use it as a part of the key
        String newKey = String.format(CacheKey.INDEX_DETAIL_KEY, videoId);

        try{
            Object cacheObj = baseCache.getOneHourCache().get(newKey, ()->{
                Video video = videoMapper.findVideoById(videoId);
                System.out.println("Test videos caching");
                return video;
            });

            if(cacheObj instanceof Video){
                return (Video)cacheObj;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
