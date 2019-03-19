package com.guigu.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.guigu.vo.MenuRoleInfoVo;
import com.guigu.vo.MenuVo;

public interface MenuDao {
	public  List<MenuVo> queryByPid(@Param(value="pid")Integer pid,@Param(value="role_id")Integer role_id);
	public int romeByid(MenuRoleInfoVo menuRoleInfoVo);
	public List<MenuVo> quermenu();
	public List<MenuVo> queryRoleId();
	public int addrome(MenuRoleInfoVo rome_info);
	public int deleterome(MenuRoleInfoVo rome_info);
	
}

