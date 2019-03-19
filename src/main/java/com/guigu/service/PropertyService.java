package com.guigu.service;

import com.guigu.vo.PageVO;
import com.guigu.vo.PropertyVo;

public interface PropertyService {
	public int addzichan(PropertyVo zichan);

	public int updatezichan(PropertyVo zichan);

	public int deletezichanById(Integer id);

	public PropertyVo queryById(Integer id);

	public PageVO queryzichanByPage(int currpage,int pagesize);
}
