package com.guigu.vo;

public class rolesinfoVo {
	private Integer roleid;
	private String rolename;
	
	public rolesinfoVo() {
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	public String toString() {
		return "rolesinfoVo [roleid=" + roleid + ", rolename=" + rolename + "]";
	}

	public rolesinfoVo(Integer roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	
}
