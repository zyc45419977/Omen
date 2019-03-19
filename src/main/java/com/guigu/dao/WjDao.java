package com.guigu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.vo.WjVo;
import com.guigu.vo.rolesinfoVo;


public interface WjDao {
	public List<WjVo> queryWjByPage(@Param("currpage")int currpage,@Param("pagesize")int pagesize);
	public int queryCount();
	public boolean addwj(WjVo wjvo);
	public boolean deletewj(WjVo vo);
	public WjVo findbyid(WjVo vo);
	public boolean updateWj(WjVo vo);
	
	
	
}
