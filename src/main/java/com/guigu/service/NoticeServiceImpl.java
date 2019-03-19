package com.guigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.NoticeDao;
import com.guigu.vo.NoticeVo;
import com.guigu.vo.PageVO;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	NoticeDao  noticeDao;
	@Override
	public int addnoticeVo(NoticeVo noticeVo) {
		
		return noticeDao.addnoticeVo(noticeVo);
	}

	@Override
	public int updatenoticeVo(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		return noticeDao.updatenoticeVo(noticeVo);
	}

	@Override
	public int deletenoticeVoById(Integer id) {
		// TODO Auto-generated method stub
		return noticeDao.deletenoticeVoById(id);
	}

	@Override
	public NoticeVo queryById(Integer id) {
		// TODO Auto-generated method stub
		return noticeDao.queryById(id);
	}

	@Override
	public PageVO querynoticeVoByPage(int currpage, int pagesize) {
		PageVO<NoticeVo> pageVO = new PageVO<NoticeVo>();
		currpage = (currpage-1)*pagesize;
		pageVO.setRows(noticeDao.findNotice(currpage, pagesize));
		pageVO.setTotal(noticeDao.queryCount());
		return pageVO;
	}

}
