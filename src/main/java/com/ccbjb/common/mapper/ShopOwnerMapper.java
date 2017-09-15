package com.ccbjb.common.mapper;


import com.ccbjb.common.domain.ShopOwner;
import com.ccbjb.common.mybatis.Mapper;

import java.util.Map;

public interface ShopOwnerMapper extends Mapper<ShopOwner> {
    ShopOwner login(Map<String, Object> map);
    ShopOwner findUserByMobile(String mobile);
}