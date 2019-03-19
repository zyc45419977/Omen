package com.guigu.vo;

public class MenuRoleInfoVo {
	private Integer role_Id;
	private Integer id;
	public Integer getRole_Id() {
		return role_Id;
	}
	public void setRole_Id(Integer role_Id) {
		this.role_Id = role_Id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public MenuRoleInfoVo(Integer role_Id, Integer id) {
		super();
		this.role_Id = role_Id;
		this.id = id;
	}
	@Override
	public String toString() {
		return "MenuRoleInfoVo [role_Id=" + role_Id + ", id=" + id + "]";
	}
	public MenuRoleInfoVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
}
