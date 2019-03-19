package com.guigu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.guigu.service.MenuService;
import com.guigu.vo.MenuRoleInfoVo;
import com.guigu.vo.MenuVo;

@Controller
@Scope("prototype")
public class MenuController {
	@Autowired
	MenuService  Menuservice;
	@RequestMapping("menu.action")
	public void querymenu(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws IOException{
		String id = request.getParameter("id");
		Object user = session.getAttribute("user");
		int role_id = Integer.parseInt(user.toString());
		int pid=0;
		if(id!=null&&id!=""){
			pid=Integer.parseInt(id);
		}
		List<MenuVo> list = Menuservice.queryByPid(pid,role_id);
		String jsonStr = JSON.toJSONString(list);
		
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().println(jsonStr);		
	}

	@RequestMapping("queryroleid.action")
	public void quermenu2(Integer id,HttpServletResponse response){
		
		List<MenuVo> list = Menuservice.queryRoleid(id);
		System.out.println(list);
		for (MenuVo menu_vo : list) {
			System.out.println(menu_vo);
		}
		String ret = JSON.toJSONString(list);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("addrome.action")
	public void addrome(HttpServletResponse response,HttpServletRequest request){
		MenuRoleInfoVo rome_info= new MenuRoleInfoVo();
		String roid=request.getParameter("roleid");
		String id=request.getParameter("id");
		rome_info.setRole_Id(Integer.parseInt(roid));
		rome_info.setId(Integer.parseInt(id));
		String str = Menuservice.addrome(rome_info);
		response.setContentType("text/json;charset=utf-8");	
		try {
			response.getWriter().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("deleterome.action")
	public void deleterome(HttpServletResponse response,HttpServletRequest request){
		MenuRoleInfoVo rome_info=new MenuRoleInfoVo();
		String roid=request.getParameter("roleid");
		String id=request.getParameter("id");
		rome_info.setRole_Id(Integer.parseInt(roid));
		rome_info.setId(Integer.parseInt(id));
		String str = Menuservice.deleterome(rome_info);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
