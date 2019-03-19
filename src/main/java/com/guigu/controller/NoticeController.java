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
import com.guigu.service.NoticeService;
import com.guigu.vo.NoticeVo;
import com.guigu.vo.PageVO;


@Controller
@Scope("prototype")
public class NoticeController {
	@Autowired
	NoticeService NoticeService; 
	@RequestMapping("Notice.action")
	private void queryNoticeByPage(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
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
		PageVO<NoticeVo> pageVO = NoticeService.querynoticeVoByPage(currpage, pagesize);
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
	@RequestMapping("addNotice.action")
	private void addNotice(NoticeVo vo,HttpServletResponse response,HttpServletRequest request) throws IOException{
		System.out.println("adnOTICE");
		response.setContentType("text/html;charset=utf-8");
		int num=NoticeService.addnoticeVo(vo);
		System.out.println(num);
		if(num>0){
			response.getWriter().write("添加成功");
		}else{
			response.getWriter().write("添加失败");
		}
	}
	@RequestMapping("delectNotice.action")
	private void delectNotice(@RequestParam(name="noticeId")Integer noticeId,HttpServletResponse response,HttpServletRequest request) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		int mun = NoticeService.deletenoticeVoById(noticeId);
		if(mun>0){
			response.getWriter().println("删除成功！");
		}else{
			response.getWriter().println("删除失败！");
		}
	}
}
