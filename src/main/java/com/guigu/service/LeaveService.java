package com.guigu.service;


import com.guigu.vo.LeaveVo;
import com.guigu.vo.PageVO;

public interface LeaveService {
	public int addleave(LeaveVo leavevo);

	public int updateleave(LeaveVo leavevo);

	public int deleteleaveById(Integer id);

	public LeaveVo queryById(Integer id);

	public PageVO queryleaveByPage(int currpage,int pagesize);
}
