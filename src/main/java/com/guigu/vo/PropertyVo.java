package com.guigu.vo;
import java.util.Date;
public class PropertyVo {
	public Integer prid;
	public String prname;
	public Integer price;
	public Date prdate;
	public String propertySults;
	public Integer userid;
	public String userAccount;
	public String prsultsgh;
	@Override
	public String toString() {
		return "PropertyVo [prid=" + prid + ", prname=" + prname + ", price=" + price + ", prdate=" + prdate
				+ ", propertySults=" + propertySults + ", userid=" + userid + ", userAccount=" + userAccount
				+ ", prsultsgh=" + prsultsgh + "]";
	}
	public PropertyVo(Integer prid, String prname, Integer price, Date prdate, String propertySults, Integer userid,
			String userAccount, String prsultsgh) {
		super();
		this.prid = prid;
		this.prname = prname;
		this.price = price;
		this.prdate = prdate;
		this.propertySults = propertySults;
		this.userid = userid;
		this.userAccount = userAccount;
		this.prsultsgh = prsultsgh;
	}
	public PropertyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getPrid() {
		return prid;
	}
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	public String getPrname() {
		return prname;
	}
	public void setPrname(String prname) {
		this.prname = prname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getPrdate() {
		return prdate;
	}
	public void setPrdate(Date prdate) {
		this.prdate = prdate;
	}
	public String getPropertySults() {
		return propertySults;
	}
	public void setPropertySults(String propertySults) {
		this.propertySults = propertySults;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getPrsultsgh() {
		return prsultsgh;
	}
	public void setPrsultsgh(String prsultsgh) {
		this.prsultsgh = prsultsgh;
	}
	
	
}
