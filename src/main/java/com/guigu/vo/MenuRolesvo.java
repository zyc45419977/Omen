package com.guigu.vo;

public class MenuRolesvo {
	private Integer roleId;
	private Integer id;
	
	public MenuRolesvo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuRolesvo(Integer roleId, Integer id) {
		super();
		this.roleId = roleId;
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MenuRolesvo [roleId=" + roleId + ", id=" + id + "]";
	}
	
	
	


}
