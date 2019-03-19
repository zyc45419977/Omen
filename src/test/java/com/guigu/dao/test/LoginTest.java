package com.guigu.dao.test;
import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.guigu.dao.LeaveInfoDao;
import com.guigu.dao.LoginDao;
import com.guigu.dao.RoleDao;
import com.guigu.dao.UsersDao;
import com.guigu.vo.LeaveVo;
import com.guigu.vo.rolesinfoVo;
import com.guigu.vo.usersVo;

public class LoginTest {
	SqlSessionFactory sqlSessionFactory=null;
	SqlSession session=null;
	@Before
	public void beforeMethod() throws IOException {
		// 1.
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 2)创建会话工厂
		// 2.1)创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 2.2)创建SqlSessionFactory对象
		sqlSessionFactory = sessionFactoryBuilder.build(inputStream);

	}
	
	@After
	public void afterMthod(){
		if(session!=null){
			session.close();
		}
	}
	@Test
	public void test02(){
		usersVo usersvo =new usersVo();
		rolesinfoVo vo=new rolesinfoVo();
		usersVo vo2=new usersVo();
		LeaveVo vo3=new LeaveVo();
		session = sqlSessionFactory.openSession();
		
		LoginDao dao = session.getMapper(LoginDao.class);
		RoleDao dao1=session.getMapper(RoleDao.class);
		UsersDao dao2=session.getMapper(UsersDao.class);
		LeaveInfoDao dao3=session.getMapper(LeaveInfoDao.class);
		vo3.setLeaveId(1);
		vo3.setLeavereSults("112312");
		/*vo3.setLeaveState("123");*/
		int num=dao3.updateLeave(vo3);
		System.out.println(num);
		/*vo.setRoleid(1);
		vo.setRolename("超级管理员");
		usersvo.setUseraccount("admin");
		usersvo.setUserpwd("123");
		vo2.setRoleid(1);*/
	/*	vo3.setLeaveId(5);
		vo3.setEndTime(null);
		vo3.setLeadId("admin");
	vo3.setLeavereSults(2);
	vo3.setLeavemanId(1);
	vo3.setLeaveContent("123");
	vo3.setStartTime(null);
	vo3.setLeaveState(2);*/
	/*	rolesinfoVo list=dao1.queryById(1);
		usersVo list2=dao2.queryById(1);
		System.out.println(list2);*/
	//int list=dao3.addLeave(vo3);
		//Dept dept = deptDao.queryById(2);
		
		//System.out.println(dept);
		
		
		/*//查询所有的部门信息
		usersVo list = dao.findusers(usersvo);
		
		*/
		System.out.println(num==1?"成功":"失败");
		session.commit();
	}
}
