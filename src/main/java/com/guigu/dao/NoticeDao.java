package com.guigu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.vo.NoticeVo;


public interface NoticeDao {
	public List<NoticeVo> findNotice(@Param("currpage")int currpage,@Param("pagesize")int pagesize);
	
	public int addnoticeVo(NoticeVo noticeVo);

	public int updatenoticeVo(NoticeVo noticeVo);

	public int deletenoticeVoById(Integer id);

	public NoticeVo queryById(Integer id);

	public int queryCount();
}
