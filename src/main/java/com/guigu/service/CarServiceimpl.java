package com.guigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.CarDao;
import com.guigu.vo.CarVo;
import com.guigu.vo.PageVO;
@Service("carService")
public class CarServiceimpl implements CarService{
	@Autowired
	CarDao cardao;
	@Override
	public int addcar(CarVo carvo) {
		// TODO Auto-generated method stub
		return cardao.addcar(carvo);
	}

	@Override
	public int updatecar(CarVo carvo) {
		// TODO Auto-generated method stub
		return cardao.updatecar(carvo);
	}

	@Override
	public int deletecarById(Integer id) {
		// TODO Auto-generated method stub
		return cardao.deletecarById(id);
	}

	@Override
	public CarVo queryById(Integer id) {
		// TODO Auto-generated method stub
		return cardao.queryById(id);
	}

	@Override
	public PageVO querycarByPage(int currpage, int pagesize) {
		PageVO<CarVo> pageVO = new PageVO<CarVo>();
		currpage = (currpage-1)*pagesize;
		pageVO.setRows(cardao.querycarByPage(currpage, pagesize));
		pageVO.setTotal(cardao.queryCount());
		return pageVO;
	}

}
