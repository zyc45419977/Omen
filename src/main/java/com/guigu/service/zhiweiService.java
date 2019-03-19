package com.guigu.service;

import com.guigu.vo.PageVO;
import com.guigu.vo.zhiweiVo;

public interface zhiweiService {
	public int addzhiwei(zhiweiVo zhiweivo);

	public int updatezhiwei(zhiweiVo zhiweivo);

	public int deletezhiweiById(Integer id);

	public zhiweiVo queryById(Integer id);

	public PageVO queryzhiweiByPage(int currpage,int pagesize);
}
