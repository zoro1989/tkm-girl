package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.TPoints;
import com.ccbjb.common.mapper.TPointsMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.TPointsDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class TPointsDaoImpl extends AbstractDao<TPoints> implements TPointsDao {
    @Resource
    TPointsMapper tPointsMapper;
    public List<TPoints> findAllPoints(Map<String, String> map){
        return tPointsMapper.findAllPoints(map);
    }
    public  TPoints findPointById(Long id) {
        return tPointsMapper.findPointById(id);
    }
}
