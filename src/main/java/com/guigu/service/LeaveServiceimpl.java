package com.guigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.LeaveInfoDao;
import com.guigu.dao.LoginDao;
import com.guigu.vo.LeaveVo;
import com.guigu.vo.PageVO;
import com.guigu.vo.zhiweiVo;
@Service("leaveService")
public class LeaveServiceimpl  implements LeaveService{
	@Autowired
	LeaveInfoDao leaveInfoDao;
	@Override
	public int addleave(LeaveVo leavevo) {
		// TODO Auto-generated method stub
		return leaveInfoDao.addLeave(leavevo);
	}

	@Override
	public int updateleave(LeaveVo leavevo) {
		//    
		return leaveInfoDao.updateLeave(leavevo);
	}

	@Override
	public int deleteleaveById(Integer id) {
		// TODO Auto-generated method stub
		return leaveInfoDao.deleteLeaveById(id);
	}

	@Override
	public LeaveVo queryById(Integer id) {
		// TODO Auto-generated method stub
		return leaveInfoDao.queryById(id);
	}

	@Override
	public PageVO queryleaveByPage(int currpage, int pagesize) {
		PageVO<LeaveVo> pageVO = new PageVO<LeaveVo>();
		currpage = (currpage-1)*pagesize;
		pageVO.setRows(leaveInfoDao.queryLeaveByPage(currpage, pagesize));
		pageVO.setTotal(leaveInfoDao.queryCount());
		return pageVO;
	}

}
