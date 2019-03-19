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
import com.guigu.service.zhiweiService;
import com.guigu.vo.PageVO;
import com.guigu.vo.rolesinfoVo;
import com.guigu.vo.zhiweiVo;

@Controller
@Scope("prototype")
public class ZhiweiController {
	@Autowired
	zhiweiService zhiweiService; 
	@RequestMapping("zhiwei.action")
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
		PageVO<zhiweiVo> pageVO = zhiweiService.queryzhiweiByPage(currpage, pagesize);
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
	@RequestMapping("addzhiwei.action")
	private void addRole(@RequestParam(name="positionId")Integer positionId,
			@RequestParam(name="positionName")String positionName,
			@RequestParam(name="positionPrincipal")String positionPrincipal,
			HttpServletResponse response,HttpServletRequest request) throws IOException{
		System.out.println("1233");
		zhiweiVo zhiwei = new zhiweiVo();
		zhiwei.setPositionId(null);
		zhiwei.setPositionName(positionName);
		zhiwei.setPositionPrincipal(positionPrincipal);
		System.out.println("roleInfo:"+zhiwei);
		response.setContentType("text/html;charset=utf-8");
		int mun = zhiweiService.addzhiwei(zhiwei);
		if(mun>0){
			response.getWriter().println("添加成功！");
		}else{
			response.getWriter().println("添加失败！");
		}
	}
	@RequestMapping("deletezhiwei.action")
	private void deleteRoleById(@RequestParam(name="positionId")Integer positionId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html;charset=utf-8");
		int mun = zhiweiService.deletezhiweiById(positionId);
		if(mun>0){
			response.getWriter().println("删除成功！");
		}else{
			response.getWriter().println("删除失败！");
		}
	}
	@RequestMapping("queryByIdzhiwei.action")	
	private void queryById(@RequestParam(name="positionId")Integer positionId,HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		zhiweiVo roleInfo = zhiweiService.queryById(positionId);
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
	@RequestMapping("updatezhiwei.action")
	private void updateRole(@RequestParam(name="positionId")Integer positionId,
			@RequestParam(name="positionName")String positionName,
			@RequestParam(name="positionPrincipal")String positionPrincipal,
			HttpServletResponse response,HttpServletRequest request) throws IOException{
		zhiweiVo zhiwei = new zhiweiVo();
		zhiwei.setPositionId(positionId);
		zhiwei.setPositionName(positionName);
		zhiwei.setPositionPrincipal(positionPrincipal);	
		response.setContentType("text/html;charset=utf-8");
		int mun = zhiweiService.updatezhiwei(zhiwei);
		if(mun>0){
			response.getWriter().println("修改成功！");
		}else{
			response.getWriter().println("修改失败！");
		}
	}
}
