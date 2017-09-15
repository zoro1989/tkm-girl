package com.ccbjb.service.points;


import com.ccbjb.common.domain.TPoints;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.model.points.TPointsModel;

import java.util.Map;

public interface IPointsService {

	Result insertPoint(TPointsModel point);

	void deletePointById(Long id);

	void updatePoint(TPoints point);

	Result selectPoint(Long id);

	Result findPage(Map<String, String> resultMap, Integer pageNo,
								 Integer pageSize);

	Result deletePointByIds(Long[] ids);
}
