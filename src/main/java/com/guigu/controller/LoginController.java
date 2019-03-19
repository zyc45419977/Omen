package com.guigu.controller;



import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guigu.service.LoginService;
import com.guigu.vo.usersVo;

@Controller
@Scope("prototype")
public class LoginController {
	@Autowired
	LoginService loginservice;
	@SuppressWarnings("unused")
	@RequestMapping("login.action")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,HttpSession session,usersVo usersvo) throws IOException{
		usersVo vo2  = loginservice.findusers(usersvo);
		ModelAndView model=new ModelAndView();
		if(vo2!=null){
			ServletContext context=session.getServletContext();
			String roldid = vo2.getRoleId().toString();
			String account = vo2.getUseraccount();
			session.setAttribute("user", roldid);
			session.setAttribute("admin",account);
			request.getSession().setAttribute("user1", vo2);
			model.setViewName("index");
		}else{
			model.setViewName("login");
		
		}
		return model;
	}
}

