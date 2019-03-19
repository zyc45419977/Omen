package com.guigu.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.guigu.service.PropertyService;
import com.guigu.vo.PageVO;
import com.guigu.vo.PropertyVo;
import com.guigu.vo.rolesinfoVo;
import com.guigu.vo.zhiweiVo;

@Controller
@Scope("prototype")
public class PropertyController {
	@Autowired
	PropertyService propertyService; 
	@RequestMapping("property.action")
	private void querypropertyByPage(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
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
		PageVO<PropertyVo> pageVO = propertyService.queryzichanByPage(currpage, pagesize);
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
	@RequestMapping("propertyadd.action")
	private void propertyadd(HttpServletResponse response,HttpServletRequest request) throws IOException, ParseException{
		String prid=request.getParameter("prid");
		String prname=request.getParameter("prname");
		String price=request.getParameter("price");
		String prdate =request.getParameter("prdate");
		String propertySults=request.getParameter("propertySults");
		String userid=request.getParameter("userid");
		PropertyVo Property = new PropertyVo();
		Property.setPrid(null);
		Property.setPrname(prname);
		Property.setPrice(Integer.parseInt(price));
		SimpleDateFormat simpldate=new SimpleDateFormat("yyyy-MM-dd");
		Property.setPrdate(simpldate.parse(prdate));
		Property.setPropertySults(propertySults);
		Property.setUserid(Integer.parseInt(userid));
		response.setContentType("text/html;charset=utf-8");
		int mun = propertyService.addzichan(Property);
		if(mun>0){
			response.getWriter().println("添加成功！");
		}else{
			response.getWriter().println("添加失败！");
		}
	}
	@RequestMapping("deleteproperty.action")
	private void deletepropertyById(@RequestParam(name="prid")Integer prid,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		int mun = propertyService.deletezichanById(prid);
		if(mun>0){
			response.getWriter().println("删除成功！");
		}else{
			response.getWriter().println("删除失败！");
		}
	}
	@RequestMapping("queryByIdzhichan.action")	
	private void queryById(@RequestParam(name="prid")Integer prid,HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		PropertyVo Property = propertyService.queryById(prid);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(Property);
		System.out.println("json:"+jsonStr);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
