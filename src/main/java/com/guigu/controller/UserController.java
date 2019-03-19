package com.guigu.controller;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import com.guigu.service.UsersService;
import com.guigu.vo.PageVO;
import com.guigu.vo.usersVo;


@Controller
@Scope("prototype")
public class UserController {

	@Autowired
	UsersService userService;

	@RequestMapping("UserInfo.action")
	private void queryUserByPage(HttpServletResponse response, HttpServletRequest request, HttpSession session)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		int currpage = 1;
		int pagesize = 10;
	
		try {
			currpage = Integer.parseInt(request.getParameter("page"));
			pagesize = Integer.parseInt(request.getParameter("rows"));
		} catch (Exception e) {
			currpage = 1;
			pagesize = 10;
		}
		PageVO<usersVo> pageVO = userService.queryuserByPage(currpage, pagesize);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(pageVO);
		System.out.println("json:" + jsonStr);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("addUser.action")
	private void addUser(usersVo vo, HttpServletResponse response, HttpServletRequest request) throws IOException {
		System.out.println("123");
		System.out.println("userVo:" + vo);
		Date date = new Date();
		System.out.println("aaaaaaaaaaaaaaaaaaaa:" + date);
		vo.setUserdate(date);
		response.setContentType("text/html;charset=utf-8");
		int mun = userService.adduser(vo);
		System.out.println("mun:" + mun);
		if (mun > 0) {
			response.getWriter().println("添加成功！");
		} else {
			response.getWriter().println("添加失败！");
		}
	}

	@RequestMapping("deleteUser.action")
	private void deleteUserById(@RequestParam(name = "userId") Integer userId, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		int mun = userService.deleteuseriById(userId);
		if (mun > 0) {
			response.getWriter().println("删除员工信息成功");
		} else {
			response.getWriter().println("删除员工信息失败");
		}
	}

/*	@RequestMapping("queryByIdUser.action")
	private void queryById(@RequestParam(name = "userId") Integer userId, HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		UserVo userVo = userService.queryById(userId);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(userVo);
		System.out.println("queryidjson:" + jsonStr);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

/*	@RequestMapping("updateUser.action")
	private void updateUser(UserVo userVo, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		
		 * UserVo userVo = new UserVo(userId, roleId, positionId, userAccount,
		 * userPwd, userName, userSex, superior, null, userSal, userCard,
		 * userTel, userEmail, userAddress);
		  Date date = new Date();
		System.out.println("aaaaaaaaaaaaaaaaaaaa:" + date);
		userVo.setUserDate(date);
		userVo.setUserSex(0);
		System.out.println("userVo:" + userVo);
		response.setContentType("text/html;charset=utf-8");
		int mun = userService.updateUser(userVo);
		if (mun > 0) {
			response.getWriter().println("�޸ĳɹ���");
		} else {
			response.getWriter().println("�޸�ʧ�ܣ�");
		}
	}*/
}
