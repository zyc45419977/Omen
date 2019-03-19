package com.guigu.vo;

import java.util.Date;

public class usersVo {
	private Integer userId;
	private Integer roleId;
	private Integer positionId;
	private String useraccount;
	private String userpwd;
	private String username;
	private Integer usersex;
	private String superior;
	private Date userdate;
	private Integer usersal;
	private String usercard;
	private String usertel;
	private String useremail;
	private String useraddress;
	private String usersex_sex;
	public usersVo() {
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public String getUseraccount() {
		return useraccount;
	}
	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUsersex() {
		return usersex;
	}
	public void setUsersex(Integer usersex) {
		this.usersex = usersex;
		if(usersex==1){
			usersex_sex="男";
		}else{
			usersex_sex="女";
		}
	}
	public String getSuperior() {
		return superior;
	}
	public void setSuperior(String superior) {
		this.superior = superior;
	}
	public Date getUserdate() {
		return userdate;
	}
	public void setUserdate(Date userdate) {
		this.userdate = userdate;
	}
	public Integer getUsersal() {
		return usersal;
	}
	public void setUsersal(Integer usersal) {
		this.usersal = usersal;
	}
	public String getUsercard() {
		return usercard;
	}
	public void setUsercard(String usercard) {
		this.usercard = usercard;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	@Override
	public String toString() {
		return "usersVo [userId=" + userId + ", roleId=" + roleId + ", positionId=" + positionId + ", useraccount="
				+ useraccount + ", userpwd=" + userpwd + ", username=" + username + ", usersex=" + usersex
				+ ", superior=" + superior + ", userdate=" + userdate + ", usersal=" + usersal + ", usercard="
				+ usercard + ", usertel=" + usertel + ", useremail=" + useremail + ", useraddress=" + useraddress + "]";
	}
	public usersVo(Integer userId, Integer roleId, Integer positionId, String useraccount, String userpwd,
			String username, Integer usersex, String superior, Date userdate, Integer usersal, String usercard,
			String usertel, String useremail, String useraddress, String usersex_sex) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.positionId = positionId;
		this.useraccount = useraccount;
		this.userpwd = userpwd;
		this.username = username;
		this.usersex = usersex;
		this.superior = superior;
		this.userdate = userdate;
		this.usersal = usersal;
		this.usercard = usercard;
		this.usertel = usertel;
		this.useremail = useremail;
		this.useraddress = useraddress;
		this.usersex_sex = usersex_sex;
	}
	
	
}
