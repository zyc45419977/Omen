package com.guigu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guigu.dao.MenuDao;
import com.guigu.vo.MenuRoleInfoVo;
import com.guigu.vo.MenuVo;


@Service("MenuService")
public class MenuServiceimpl  implements MenuService{
	@Autowired
	MenuDao menuDao;

	@Override
	public List<MenuVo> queryByPid(Integer pid, Integer role_id) {
		List<MenuVo> list = menuDao.queryByPid(pid,role_id);
		for (MenuVo menuInfo : list) {
			if (menuInfo.getPid() == 0) {
				continue;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("url", menuInfo.getUrl());
			menuInfo.setAttributes(map);
		}
		return list;
	}

	@Override
	public List<MenuVo> quermenu(Integer romeid) {
		int rminfo = 0;
		List<MenuVo> list = menuDao.quermenu();
		for (MenuVo menuvo : list) {
			MenuRoleInfoVo menuRoleInfoVo = new MenuRoleInfoVo(romeid,menuvo.getId());
			rminfo = menuDao.romeByid(menuRoleInfoVo);
			System.out.println(rminfo);
			if(rminfo>0){
				menuvo.setRomestate("已授权");
			}else{
				menuvo.setRomestate("未授权");
			}
		}
		return list;
	}

	@Override
	public List<MenuVo> queryRoleid(Integer roleid) {
		List<MenuVo> list=menuDao.queryRoleId();
		for (MenuVo menuvo : list) {
			MenuRoleInfoVo menuRoleInfoVo = new MenuRoleInfoVo(roleid,menuvo.getId());
			int num= menuDao.romeByid(menuRoleInfoVo);
		
			if(num>0){
				menuvo.setRomestate("已授权");
			}else{
				menuvo.setRomestate("未授权");
			}
		}
		return list;
	}

	@Override
	public String addrome(MenuRoleInfoVo romeinfo) {
		// TODO Auto-generated method stub
		System.out.println("-------------"+romeinfo);
				if(menuDao.addrome(romeinfo)>0){
					return "授权成功";
				}else{
					return "授权失败";
				}
	}

	@Override
	public String deleterome(MenuRoleInfoVo romeinfo) {
		// TODO Auto-generated method stub
				if(menuDao.deleterome(romeinfo)>0){
					return "取消授权成功";
				}else{
					return "取消授权失败";
				}
	}
}	
