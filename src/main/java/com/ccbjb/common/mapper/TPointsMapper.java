package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.TPoints;
import com.ccbjb.common.mybatis.Mapper;

import java.util.List;
import java.util.Map;

public interface TPointsMapper extends Mapper<TPoints> {
    List<TPoints> findAllPoints(Map<String, String> map);
    TPoints findPointById(Long id);
}