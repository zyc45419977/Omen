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

import com.guigu.dao.LoginDao;
import com.guigu.dao.WjDao;
import com.guigu.vo.WjVo;
import com.guigu.vo.usersVo;

public class FilesDaoTest {
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
		WjVo  WjVo =new WjVo();
		session = sqlSessionFactory.openSession();
		
		WjDao dao = session.getMapper(WjDao.class);
		
		WjVo.setFileId(110);
		WjVo.setFileUrl("12323");
		WjVo.setFineContent("123");
		WjVo.setUserName("123");
		WjVo.setFineName("123");
		WjVo.setFileDate(null);
		//根据id查询部门
		
		//Dept dept = deptDao.queryById(2);
		
		//System.out.println(dept);
		
		boolean num = dao.addwj(WjVo);
		if(num){
			System.out.println("天基础");
		}else{
			System.out.println("12");
		}
		session.commit();
		
		
	}
}
