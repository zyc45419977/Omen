package com.guigu.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.servlet.config.VelocityConfigurerBeanDefinitionParser;

import com.alibaba.fastjson.JSON;
import com.guigu.dbutil.DBUtil;
import com.guigu.vo.rolesinfoVo;

import redis.clients.jedis.Jedis;


public class Mylistener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("进来了");
		Connection connection=null;
		ArrayList<rolesinfoVo> list = new ArrayList<rolesinfoVo>();
		PreparedStatement pstmt = null;
		String sql = "select * from role";
		ResultSet rs=null;
		try {
			connection = DBUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs=	pstmt.executeQuery();
			if (rs.next()) {
				rolesinfoVo vo=new rolesinfoVo();
				vo.setRoleid(rs.getInt(1));
				vo.setRolename(rs.getString(2));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ad=JSON.toJSONString(list);

		Jedis jedis =new Jedis("192.168.43.250", 6379);
		jedis.auth("123456");
		jedis.set("jediskey", ad);
		System.out.println(jedis.get("jediskey"));
		jedis.disconnect();
		
		
	}

}
