package com.guigu.service;

import com.guigu.vo.NoticeVo;
import com.guigu.vo.PageVO;


public interface NoticeService {
	public int addnoticeVo(NoticeVo noticeVo);

	public int updatenoticeVo(NoticeVo noticeVo);

	public int deletenoticeVoById(Integer id);

	public NoticeVo queryById(Integer id);

	public PageVO querynoticeVoByPage(int currpage,int pagesize);
}
