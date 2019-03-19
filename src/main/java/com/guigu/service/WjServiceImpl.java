package com.guigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.WjDao;
import com.guigu.vo.PageVO;
import com.guigu.vo.WjVo;
@Service("WjService")
public class WjServiceImpl implements WjService{
	@Autowired
	WjDao wjdao;
	@Override
	public PageVO queryUserByPage(int currpage, int pagesize) {
		PageVO pageVO = new PageVO();
		pageVO.setRows(wjdao.queryWjByPage(currpage-1, pagesize));
		pageVO.setTotal(wjdao.queryCount());
		return pageVO;
	}
	@Override
	public boolean addwj(WjVo wjvo) {
		System.out.println("tianjia");
		return wjdao.addwj(wjvo);
	}


	@Override
	public WjVo findbyid(WjVo vo) {
		// TODO Auto-generated method stub
		return wjdao.findbyid(vo);
	}
	@Override
	public boolean updateWj(WjVo vo) {
		// TODO Auto-generated method stub
		return wjdao.updateWj(vo);
	}
	@Override
	public boolean deletewj(WjVo vo ) {
		// TODO Auto-generated method stub
		return wjdao.deletewj(vo);
	}

	
}
