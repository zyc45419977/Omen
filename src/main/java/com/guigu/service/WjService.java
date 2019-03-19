package com.guigu.service;

import com.guigu.vo.PageVO;
import com.guigu.vo.WjVo;

public interface WjService {
	
	public PageVO queryUserByPage(int currpage,int pagesize);
	public boolean addwj(WjVo wjvo);


//	public boolean deletewj(int Wjid);
	public WjVo findbyid(WjVo vo);
	public boolean updateWj(WjVo vo);
	public boolean deletewj(WjVo vo);

}	
