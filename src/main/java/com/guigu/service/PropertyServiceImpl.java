package com.guigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guigu.dao.PropertyDao;
import com.guigu.vo.PageVO;
import com.guigu.vo.PropertyVo;
@Service("PropertyService")
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	PropertyDao  propertyDao;
	@Override
	public int addzichan(PropertyVo zichan) {
		// TODO Auto-generated method stub
		return propertyDao.addzichan(zichan);
	}

	@Override
	public int updatezichan(PropertyVo zichan) {
		// TODO Auto-generated method stub
		return propertyDao.updatezichan(zichan);
	}

	@Override
	public int deletezichanById(Integer id) {
		// TODO Auto-generated method stub
		return propertyDao.deletezichanById(id);
	}

	@Override
	public PropertyVo queryById(Integer id) {
		// TODO Auto-generated method stub
		return propertyDao.queryById(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PageVO queryzichanByPage(int currpage, int pagesize) {
		PageVO<PropertyVo> pageVO = new PageVO<PropertyVo>();
		currpage = (currpage-1)*pagesize;
		pageVO.setRows(propertyDao.queryzichanByPage(currpage, pagesize));
		pageVO.setTotal(propertyDao.queryCount());
		return pageVO;
	}

}
