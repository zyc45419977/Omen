package com.guigu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.guigu.vo.rolesinfoVo;

public interface RoleDao {	
	public int addRole(rolesinfoVo rolevo);

	public int updateRole(rolesinfoVo rolevo);

	public int deleteRoleById(Integer id);

	public rolesinfoVo queryById(Integer id);

	public List<rolesinfoVo> queryRoleByPage(@Param("currpage")int currpage,@Param("pagesize")int pagesize);

	public int queryCount();
}
