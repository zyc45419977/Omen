package com.guigu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.guigu.vo.CarVo;


public interface CarDao {
	public int addcar(CarVo carvo);

	public int updatecar(CarVo carvo);

	public int deletecarById(Integer id);

	public CarVo queryById(Integer id);

	public List<CarVo> querycarByPage(@Param("currpage")int currpage,@Param("pagesize")int pagesize);

	public int queryCount();
}
