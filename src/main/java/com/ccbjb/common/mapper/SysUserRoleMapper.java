package com.ccbjb.common.mapper;

import com.ccbjb.common.mybatis.Mapper;
import com.ccbjb.common.domain.SysUserRole;

import java.util.List;
import java.util.Map;

public interface SysUserRoleMapper extends Mapper<SysUserRole> {

    int deleteByUserId(Long id);

    int deleteRoleByUserIds(Map<String, Object> resultMap);

    List<Long> findUserIdByRoleId(Long id);
}