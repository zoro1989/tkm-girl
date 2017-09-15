package com.ccbjb.service.points.impl;

import com.ccbjb.common.domain.TPoints;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.TPointsDao;
import com.ccbjb.model.points.TPointsModel;
import com.ccbjb.service.points.IPointsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.rowset.serial.SerialBlob;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("unchecked")
public class PointServiceImpl implements IPointsService {

	@Autowired
	TPointsDao tPointsDao;


	@Transactional
	public Result insertPoint(TPointsModel model) {
		Result result = null;
		try {
			TPoints point = new TPoints();
			point.setId(model.getId());
			point.setTitle(model.getTitle());
			point.setParentId(model.getParentId());
			java.sql.Blob blob = new SerialBlob(model.getDetail().getBytes());
			point.setDetail(blob);
			if(StringUtils.isBlank(point.getId())){
				tPointsDao.save(point);
			}else{
				tPointsDao.update(point);
			}
			result = ResultGenerator.genSuccessResult("成功添加了一个知识点");
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "添加知识点报错。source[%s]");
			result = ResultGenerator.genFailResult();
		}
		return result;
	}

	@Transactional
	public void deletePointById(Long id) {
		tPointsDao.deleteById(id);
	}

	@Transactional
	public void updatePoint(TPoints point) {
		tPointsDao.update(point);
	}

	@Override
	@Transactional
	public Result findPage(Map<String, String> resultMap,
						   Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<TPoints> list = tPointsDao.findAllPoints(resultMap);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	public Result selectPoint(Long id) {
		TPoints point = tPointsDao.findPointById(id);
		TPointsModel model = new TPointsModel();
		model.setId(point.getId());
		model.setTitle(point.getTitle());
		model.setParentId(point.getParentId());
		Object detail = point.getDetail();
		model.setDetail(StringUtils.isNotBlank(detail)?new String((byte[])detail):"");
		return ResultGenerator.genSuccessResult(model);
	}

	@Transactional
	public Result deletePointByIds(Long[] ids) {
		Result result = null;
		try {
			int count=0;
			String resultMsg = "";

			for (Long id : ids) {
				this.deletePointById(id);
				count++;
			}
			resultMsg = "成功删除"+count+"个知识点！";
			result = ResultGenerator.genSuccessResult(resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除知识点出现错误，ids[%s]", ids);
			result = ResultGenerator.genFailResult();
		}
		return result;
	}
	
}
