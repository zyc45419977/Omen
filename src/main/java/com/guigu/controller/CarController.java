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
import com.guigu.service.CarService;
import com.guigu.vo.CarVo;
import com.guigu.vo.PageVO;

@Controller
@Scope("prototype")
public class CarController {
	@Autowired
	CarService carService; 
	@RequestMapping("car.action")
	private void querycarByPage(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
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
		PageVO<CarVo> pageVO = carService.querycarByPage(currpage, pagesize);
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

	@RequestMapping("addcar.action")
	private void addRole(HttpServletResponse response,HttpServletRequest request,CarVo vo) throws IOException{
		vo.setCarId(null);
		response.setContentType("text/html;charset=utf-8");
		int mun = carService.addcar(vo);
		if(mun>0){
			response.getWriter().println("添加成功！");
		}else{
			response.getWriter().println("添加失败！");
		}
	}
	@RequestMapping("queryByIdcar.action")	
	private void queryById(@RequestParam(name="carId")Integer carId,HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		CarVo carvo = carService.queryById(carId);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(carvo);
		System.out.println("json:"+jsonStr);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("updatecar.action")
	private void updateRole(@RequestParam(name="carId")Integer carId,
			@RequestParam(name="carState")String carState,
			HttpServletResponse response,HttpServletRequest request) throws IOException{
		System.out.println("进了action");
		CarVo carvo = new CarVo();
		carvo.setCarId(carId);
		carvo.setCarState(carState);
		response.setContentType("text/html;charset=utf-8");
		int mun = carService.updatecar(carvo);
		if(mun>0){
			response.getWriter().println("修改成功！");
		}else{
			response.getWriter().println("修改失败！");
		}
	}
	@RequestMapping("deletecar.action")
	private void deletecar(@RequestParam(name="carId")Integer carId,HttpServletResponse response,HttpServletRequest request) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		int mun=carService.deletecarById(carId);
		if(mun>0){
			response.getWriter().println("删除信息成功！");
		}else{
			response.getWriter().println("删除信息失败！");
		}
	}
}
