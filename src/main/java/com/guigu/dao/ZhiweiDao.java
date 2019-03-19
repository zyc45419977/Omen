package com.guigu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.guigu.vo.zhiweiVo;

public interface ZhiweiDao {
	public int addzhiwei(zhiweiVo zhiweivo);

	public int updatezhiwei(zhiweiVo zhiweivo);

	public int deletezhiweiById(Integer id);

	public zhiweiVo queryById(Integer id);

	public List<zhiweiVo> queryzhiweiByPage(@Param("currpage")int currpage,@Param("pagesize")int pagesize);

	public int queryCount1();
}
