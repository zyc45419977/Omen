package com.guigu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.guigu.vo.usersVo;

public interface UsersDao {
	public int addUsers(usersVo uservo);

	public int updateUsers(usersVo uservo);

	public int deleteUsersById(Integer id);

	public usersVo queryById(Integer id);

	public List<usersVo> queryUserByPage(@Param("currPage")int currpage,@Param("pageSize")int pagesize);

	public  List<usersVo> queryByName(@Param("currPage")int currPage,@Param("pageSize")int pageSize,@Param("name")String name);
	
	public int queryCount();
}
