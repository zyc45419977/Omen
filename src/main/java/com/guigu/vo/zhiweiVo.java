package com.guigu.vo;

public class zhiweiVo {
	/*positionId INT(10)  AUTO_INCREMENT PRIMARY KEY,
	positionName VARCHAR(20) NOT NULL,
	positionPrincipal VARCHAR(20) NOT NULL*/
	public Integer positionId;
	public String positionName;
	public String positionPrincipal;
	@Override
	public String toString() {
		return "zhiweiVo [positionId=" + positionId + ", positionName=" + positionName + ", positionPrincipal="
				+ positionPrincipal + "]";
	}
	public zhiweiVo(Integer positionId, String positionName, String positionPrincipal) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
		this.positionPrincipal = positionPrincipal;
	}
	public zhiweiVo() {
	
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getPositionPrincipal() {
		return positionPrincipal;
	}
	public void setPositionPrincipal(String positionPrincipal) {
		this.positionPrincipal = positionPrincipal;
	}
	

}
