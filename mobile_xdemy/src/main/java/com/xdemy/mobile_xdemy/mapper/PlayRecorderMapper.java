package com.xdemy.mobile_xdemy.mapper;

import com.xdemy.mobile_xdemy.model.entity.PlayRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayRecorderMapper {
    int createRecord(PlayRecord playRecord);
}
