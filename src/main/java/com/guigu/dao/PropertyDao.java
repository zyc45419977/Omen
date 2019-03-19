package com.guigu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.vo.PropertyVo;


public interface PropertyDao {
	public int addzichan(PropertyVo zichan);

	public int updatezichan(PropertyVo zichan);

	public int deletezichanById(Integer id);

	public PropertyVo queryById(Integer id);

	public List<PropertyVo> queryzichanByPage(@Param("currpage")int currpage,@Param("pagesize")int pagesize);

	public int queryCount();
}
