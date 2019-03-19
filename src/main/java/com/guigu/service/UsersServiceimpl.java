package com.guigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.UsersDao;
import com.guigu.vo.PageVO;
import com.guigu.vo.usersVo;

@Service("UsersService")
public class UsersServiceimpl implements UsersService{
	@Autowired
	UsersDao usersdao;
	@Override
	public int adduser(usersVo uservo) {
		// TODO Auto-generated method stub
		return usersdao.addUsers(uservo);
	}

	@Override
	public int updateuser(usersVo uservo) {
		// TODO Auto-generated method stub
		return usersdao.updateUsers(uservo);
	}

	@Override
	public int deleteuseriById(Integer id) {
		// TODO Auto-generated method stub
		return usersdao.deleteUsersById(id);
	}

	@Override
	public usersVo queryById(Integer id) {
		// TODO Auto-generated method stub
		return usersdao.queryById(id);
	}

	@Override
	public PageVO<usersVo> queryuserByPage(int currpage, int pagesize) {
		PageVO<usersVo> pageVO = new PageVO<usersVo>();
		currpage = (currpage-1)*pagesize;
		pageVO.setRows(usersdao.queryUserByPage(currpage, pagesize));
		pageVO.setTotal(usersdao.queryCount());
		return pageVO;
	}

}
