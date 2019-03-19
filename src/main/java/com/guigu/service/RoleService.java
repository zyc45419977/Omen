package com.guigu.service;


import com.guigu.vo.PageVO;
import com.guigu.vo.rolesinfoVo;

public interface RoleService {
	public int addRole(rolesinfoVo RoleInfo);

	public int updateRole(rolesinfoVo RoleInfo);

	public int deleteRoleById(Integer id);

	public rolesinfoVo queryById(Integer id);

	public PageVO queryRoleByPage(int currpage,int pagesize);

}
