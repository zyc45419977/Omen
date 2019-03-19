package com.guigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.LoginDao;
import com.guigu.vo.usersVo;
@Service("LoginService")
public class LoginServiceImpl  implements LoginService{
	@Autowired
	LoginDao logindao;

	

	@Override
	public usersVo findusers(usersVo usersvo) {
		System.out.println("123");
		// TODO Auto-generated method stub
		return logindao.findusers(usersvo);
	}
}
