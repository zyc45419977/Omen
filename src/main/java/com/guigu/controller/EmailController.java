package com.guigu.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.guigu.service.EmailService;
import com.guigu.vo.EmailVo;
import com.guigu.vo.PageVO;
import com.guigu.vo.zhiweiVo;
@Controller
@Scope("prototype")
public class EmailController {
	@Autowired
	EmailService emailService; 
	@RequestMapping("emali.action")
	private void queryRoleByPage(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		int currpage =1;
		int pagesize = 10;
		//获取页面传递过来的当前页面和每页显示记录数
		try {
			currpage = Integer.parseInt(request.getParameter("page"));
			pagesize = Integer.parseInt(request.getParameter("rows"));
		} catch (Exception e) {
			currpage =1;
			pagesize = 10;
		}
		@SuppressWarnings("unchecked")
		PageVO<EmailVo> pageVO = emailService.queryemaliByPage(currpage, pagesize);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(pageVO);
		System.out.println("json:"+jsonStr);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
			System.out.println("查询成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("addemail.action")
	private void addRole(@RequestParam(name="emailId")Integer emailId,
			@RequestParam(name="emailName")String emailName,
			@RequestParam(name="emailHeadline")String emailHeadline,
			@RequestParam(name="emailContent")String emailContent,
			@RequestParam(name="emailRecipients")String emailRecipients,
			HttpServletResponse response,HttpServletRequest request) throws IOException{
		System.out.println("1233");
		EmailVo emailvo = new EmailVo();
		emailvo.setEmailId(null);
		emailvo.setEmailName(emailName);
		emailvo.setEmailContent(emailContent);
		emailvo.setEmailHeadline(emailHeadline);
		emailvo.setEmailRecipients(emailRecipients);
		System.out.println("roleInfo:"+emailvo);
		response.setContentType("text/html;charset=utf-8");
		int mun = emailService.addemali(emailvo);
		if(mun>0){
			response.getWriter().println("添加成功！");
		}else{
			response.getWriter().println("添加失败！");
		}
	}
	
	@RequestMapping("deleteemail.action")
	private void deleteemail(@RequestParam(name="emailId")Integer emailId,HttpServletResponse response,HttpServletRequest request) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		int num=emailService.deleteemaliById(emailId);
		if(num>0){
			response.getWriter().println("删除邮件信息成功！");
		}else{
			response.getWriter().println("删除信息失败！");
		}
	}
	
	

}
