package com.guigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guigu.dao.EmailDao;
import com.guigu.vo.EmailVo;
import com.guigu.vo.PageVO;
import com.guigu.vo.zhiweiVo;
@Service("emailService")
public class EmailServiceimpl implements EmailService{
	@Autowired
	EmailDao emaildao;
	@Override
	public int addemali(EmailVo emalivo) {
		// TODO Auto-generated method stub
		return emaildao.addemail(emalivo);
	}

	@Override
	public int updateemali(EmailVo emalivo) {
		// TODO Auto-generated method stub
		return emaildao.updateemail(emalivo);
	}

	@Override
	public int deleteemaliById(Integer id) {
		// TODO Auto-generated method stub
		return emaildao.deleteemailById(id);
	}

	@Override
	public EmailVo queryById(Integer id) {
		// TODO Auto-generated method stub
		return emaildao.queryById(id);
	}

	@Override
	public PageVO queryemaliByPage(int currpage, int pagesize) {
		PageVO<EmailVo> pageVO = new PageVO<EmailVo>();
		currpage = (currpage-1)*pagesize;
		pageVO.setRows(emaildao.queryemailByPage(currpage, pagesize));
		pageVO.setTotal(emaildao.queryCount());
		return pageVO;
	}

}
