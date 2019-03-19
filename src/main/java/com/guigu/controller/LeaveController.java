package com.guigu.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.gson.Gson;
import com.guigu.service.LeaveService;
import com.guigu.vo.LeaveVo;
import com.guigu.vo.PageVO;

@Controller
@Scope("prototype")
public class LeaveController {
	@Autowired
	LeaveService leaveService; 
	@RequestMapping("leave.action")
	private void queryleaveByPage(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		int currpage =1;
		int pagesize = 10;
		try {
			currpage = Integer.parseInt(request.getParameter("page"));
			pagesize = Integer.parseInt(request.getParameter("rows"));
		} catch (Exception e) {
			currpage =1;
			pagesize = 10;
		}
		@SuppressWarnings("unchecked")
		PageVO<LeaveVo> pageVO = leaveService.queryleaveByPage(currpage, pagesize);
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
/*	public Integer leaveId;
	public Integer ;
	public String leaveContent;
	public Date startTime;
	public Date endTime;
	public String leaveState;
	public String leavereSults;
	public String leadId;*/
	@RequestMapping("addleave.action")
	private void addleave(HttpServletResponse response,HttpServletRequest request) throws IOException, ParseException{
		String leaveid=request.getParameter("leaveId");
		String leavemanId=request.getParameter("leavemanId");
		String leaveContent=request.getParameter("leaveContent");
		String startTime =request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String leavereSults=request.getParameter("leavereSults");
		String leadId=request.getParameter("leadId");
		LeaveVo leaveVo=new LeaveVo();
		leaveVo.setLeaveId(null);
		leaveVo.setLeavemanId(leavemanId);
		leaveVo.setLeaveContent(leaveContent);
		SimpleDateFormat simpldate=new SimpleDateFormat("yyyy-MM-dd");
		leaveVo.setStartTime(simpldate.parse(endTime));
		leaveVo.setEndTime(simpldate.parse(startTime));
		leaveVo.setLeavereSults(leavereSults);
		leaveVo.setLeadId(leadId);
		System.out.println("roleInfo:"+leaveVo);
		response.setContentType("text/html;charset=utf-8");
		int mun = leaveService.addleave(leaveVo);
		System.out.println(mun);
		if(mun>0){
			response.getWriter().println("添加成功！");
		}else{
			response.getWriter().println("添加失败！");
		}
	}
	@RequestMapping("queryByIdleave.action")	
	private void queryById(@RequestParam(name="leaveId")Integer leaveId,HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		LeaveVo Leavevo = leaveService.queryById(leaveId);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(Leavevo);
		System.out.println("--------------------:"+jsonStr);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("deleteleave.action")
	private void deleteRoleById(@RequestParam(name="leaveId")Integer leaveId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		int mun = leaveService.deleteleaveById(leaveId);
		if(mun>0){
			response.getWriter().println("删除成功！");
		}else{
			response.getWriter().println("删除失败！");
		}
	}
	@RequestMapping("updateleave.action")
	private void updateleave(
		/*	@RequestParam(name="LeaveId")Integer LeaveId,
			@RequestParam(name="leavereSults")String leavereSults,*/
			HttpServletResponse response,
			HttpServletRequest request) throws IOException{
	System.out.println("——————————————");
	String leaveid=request.getParameter("leaveId");
	String leavereSults=request.getParameter("leavereSults");
	LeaveVo leaveVo=new LeaveVo();
	leaveVo.setLeaveId(Integer.parseInt(leaveid));	
	leaveVo.setLeavereSults(leavereSults);

	System.out.println(leaveid);
	System.out.println(leavereSults);
		response.setContentType("text/html;charset=utf-8");
	int mun = leaveService.updateleave(leaveVo);
		System.out.println(mun);
		if(mun>0){
			
			response.getWriter().println("修改成功！");
		}else{
			response.getWriter().println("修改失败！");
		}
	}
}
