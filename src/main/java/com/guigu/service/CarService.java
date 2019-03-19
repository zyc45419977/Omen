package com.guigu.service;

import com.guigu.vo.CarVo;
import com.guigu.vo.PageVO;

public interface CarService {
	public int addcar(CarVo carvo);

	public int updatecar(CarVo carvo);

	public int deletecarById(Integer id);

	public CarVo queryById(Integer id);

	public PageVO querycarByPage(int currpage,int pagesize);
}
