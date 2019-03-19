package com.guigu.service;

import java.util.List;

import com.guigu.vo.MenuRoleInfoVo;
import com.guigu.vo.MenuVo;

public interface MenuService {
	
	public  List<MenuVo> queryByPid(Integer pid,Integer role_id);
	public List<MenuVo> quermenu(Integer romeid);
	public List<MenuVo> queryRoleid(Integer roleid);
/*	public void queryid()*/
	public String addrome(MenuRoleInfoVo romeinfo);
	public String deleterome(MenuRoleInfoVo romeinfo);

	
}	
