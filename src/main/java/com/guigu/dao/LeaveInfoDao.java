package com.guigu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.guigu.vo.LeaveVo;


public interface LeaveInfoDao {
	public int addLeave(LeaveVo leavevo);

	public int updateLeave(LeaveVo leavevo);

	public int deleteLeaveById(Integer id);

	public LeaveVo queryById(Integer id);

	public List<LeaveVo> queryLeaveByPage(@Param("currpage")int currpage,@Param("pagesize")int pagesize);

	public int queryCount();
}
