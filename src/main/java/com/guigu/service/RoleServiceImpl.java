package com.guigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.RoleDao;
import com.guigu.vo.PageVO;
import com.guigu.vo.rolesinfoVo;


@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDao roleDao;

	@Override
	public int addRole(rolesinfoVo RoleInfo) {
		// TODO Auto-generated method stub
		return roleDao.addRole(RoleInfo);
	}

	@Override
	public int updateRole(rolesinfoVo RoleInfo) {
		return roleDao.updateRole(RoleInfo);
	}

	@Override
	public int deleteRoleById(Integer id) {
		// TODO Auto-generated method stub
		 return roleDao.deleteRoleById(id);
	}

	@Override
	public rolesinfoVo queryById(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.queryById(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PageVO queryRoleByPage(int currpage, int pagesize) {
		PageVO<rolesinfoVo> pageVO = new PageVO<rolesinfoVo>();
		currpage = (currpage-1)*pagesize;
		pageVO.setRows(roleDao.queryRoleByPage(currpage, pagesize));
		pageVO.setTotal(roleDao.queryCount());
		return pageVO;
	}
}
