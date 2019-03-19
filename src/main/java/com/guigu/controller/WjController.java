 package com.guigu.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.guigu.service.WjService;
import com.guigu.vo.PageVO;
import com.guigu.vo.WjVo;




@Controller
@Scope("prototype")
public class WjController {
	@Autowired
	WjService  WjService;
	WjVo vo=new WjVo();
	
	@RequestMapping("querywj.action")
	public void query(HttpServletRequest request,HttpServletResponse response){
		System.out.println("WjController");
	
		int currpage=1;
		int pagesize=10;
		try{
			currpage = Integer.parseInt(request.getParameter("page"));
			pagesize = Integer.parseInt(request.getParameter("rows"));
		}catch(Exception e){
			currpage =1;
			pagesize = 10;
		}
		PageVO pagevo=WjService.queryUserByPage(currpage, pagesize);
		String str=JSON.toJSONString(pagevo);
		System.out.println(str);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("addwj.action")
	public void add(HttpServletRequest request,WjVo vo) throws IOException{
			System.out.println("添加");
	try {
	
		BeanUtils.populate(vo, request.getParameterMap());
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			boolean str = WjService.addwj(vo);
		System.out.println(str);
		
			
			//request.setAttribute("InfoMessage", str);
	}
	@RequestMapping("deletewj.action")
	public void deletewj(HttpServletRequest request,HttpServletResponse response){
			WjVo vo=new WjVo();
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String fileId=request.getParameter("fileId");
			vo.setFileId(Integer.parseInt(fileId));
			boolean flag=WjService.deletewj(vo);
	}
	@RequestMapping("updatewj.action")
	public void update(HttpServletRequest request,HttpServletResponse response){
		WjVo vo=new WjVo();
		boolean flag=WjService.updateWj(vo);
	}
}
