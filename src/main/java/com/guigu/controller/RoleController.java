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
import com.guigu.service.RoleService;
import com.guigu.vo.PageVO;
import com.guigu.vo.rolesinfoVo;
@Controller
@Scope("prototype")
public class RoleController {
	@Autowired
	RoleService roleService; 
	
	@RequestMapping("Role.action")
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
		PageVO<rolesinfoVo> pageVO = roleService.queryRoleByPage(currpage, pagesize);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(pageVO);
		System.out.println("json:"+jsonStr);
		System.out.println(jsonStr);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
			System.out.println("查询成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("addRole.action")
	private void addRole(@RequestParam(name="roleid")Integer roleid,@RequestParam(name="rolename")String rolename,HttpServletResponse response,HttpServletRequest request) throws IOException{
		System.out.println("1233");
		rolesinfoVo roleInfo = new rolesinfoVo();
		roleInfo.setRoleid(null);
		roleInfo.setRolename(rolename);
		System.out.println("roleInfo:"+roleInfo);
		response.setContentType("text/html;charset=utf-8");
		int mun = roleService.addRole(roleInfo);
		if(mun>0){
			response.getWriter().println("添加成功！");
		}else{
			response.getWriter().println("添加失败！");
		}
	}
	@RequestMapping("deleteRole.action")
	private void deleteRoleById(@RequestParam(name="roleid")Integer roleid,HttpServletRequest request,HttpServletResponse response) throws IOException{
	/*	Integer roleid = Integer.parseInt(request.getParameter("roleId"));*/
		response.setContentType("text/html;charset=utf-8");
		int mun = roleService.deleteRoleById(roleid);
		if(mun>0){
			response.getWriter().println("删除成功！");
		}else{
			response.getWriter().println("删除失败！");
		}
	}
	@RequestMapping("queryByIdRole.action")	
	private void queryById(@RequestParam(name="roleid")Integer roleid,HttpServletRequest request,HttpServletResponse response) {
		/*Integer roleid = Integer.parseInt(request.getParameter("roleId"));*/
		response.setContentType("text/html;charset=utf-8");
		rolesinfoVo roleInfo = roleService.queryById(roleid);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(roleInfo);
		System.out.println("json:"+jsonStr);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("updateRole.action")
	private void updateRole(@RequestParam(name="roleid")Integer roleid,@RequestParam(name="rolename")String rolename,HttpServletResponse response,HttpServletRequest request) throws IOException{
		rolesinfoVo roleInfo = new rolesinfoVo();
		roleInfo.setRoleid(roleid);
		roleInfo.setRolename(rolename);
		System.out.println("roleInfo:"+roleInfo);
		response.setContentType("text/html;charset=utf-8");
		int mun = roleService.updateRole(roleInfo);
		if(mun>0){
			response.getWriter().println("修改成功！");
		}else{
			response.getWriter().println("修改失败！");
		}
	}
}
