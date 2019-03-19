package com.guigu.service;

import com.guigu.vo.PageVO;
import com.guigu.vo.usersVo;


public interface UsersService {
	public int adduser(usersVo uservo);

	public int updateuser(usersVo uservo);

	public int deleteuseriById(Integer id);

	public usersVo queryById(Integer id);

	@SuppressWarnings("rawtypes")
	public PageVO queryuserByPage(int currpage,int pagesize);
}
