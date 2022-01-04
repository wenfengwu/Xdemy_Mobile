package com.xdemy.mobile_xdemy.service.impl;

import com.xdemy.mobile_xdemy.mapper.*;
import com.xdemy.mobile_xdemy.model.entity.Episode;
import com.xdemy.mobile_xdemy.model.entity.PlayRecord;
import com.xdemy.mobile_xdemy.model.entity.Video;
import com.xdemy.mobile_xdemy.model.entity.VideoOrder;
import com.xdemy.mobile_xdemy.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecorderMapper playRecorderMapper;


    //make video order
    @Override
    @Transactional
    public int createOrder(int userId, int videoId) {
        //check if video has been purchase
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1);

        if(videoOrder != null){return 0;}

        Video video = videoMapper.findById(videoId);

        VideoOrder newOrder = new VideoOrder();
        newOrder.setCreateTime(new Date());
        newOrder.setOutTradeNo(UUID.randomUUID().toString());
        newOrder.setState(1);
        newOrder.setTotalFee(video.getPrice());
        newOrder.setUserId(userId);
        newOrder.setVideoId(videoId);
        newOrder.setVideoImg(video.getCoverImg());
        newOrder.setVideoTitle(video.getTitle());

        int order = videoOrderMapper.createOrder(newOrder);

        //generate play record
        if(order == 1){
            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);
            if(episode == null){
                return -1;
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setVideoId(videoId);
            playRecord.setEpisodeId(episode.getId());
            playRecord.setUserId(userId);
            playRecorderMapper.createRecord(playRecord);

        }
        return order;
    }

    @Override
    public List<VideoOrder> findAllVideosByUserId(Integer userId) {
        return videoOrderMapper.findAllVideosByUserId(userId);
    }
}
