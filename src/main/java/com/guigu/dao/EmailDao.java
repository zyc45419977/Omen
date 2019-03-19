package com.guigu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.guigu.vo.EmailVo;

public interface EmailDao {
	public int addemail(EmailVo emailvo);

	public int updateemail(EmailVo emailvo);

	public int deleteemailById(Integer id);

	public EmailVo queryById(Integer id);

	public List<EmailVo> queryemailByPage(@Param("currpage")int currpage,@Param("pagesize")int pagesize);

	public int queryCount();
}
