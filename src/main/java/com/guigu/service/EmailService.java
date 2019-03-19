package com.guigu.service;

import com.guigu.vo.EmailVo;
import com.guigu.vo.PageVO;

public interface EmailService {
	public int addemali(EmailVo emalivo);

	public int updateemali(EmailVo emalivo);

	public int deleteemaliById(Integer id);

	public EmailVo queryById(Integer id);

	public PageVO queryemaliByPage(int currpage,int pagesize);
}
