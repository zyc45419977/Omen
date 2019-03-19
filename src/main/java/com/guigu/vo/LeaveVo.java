package com.guigu.vo;

import java.util.Date;

public class LeaveVo {
	/*请假ID leaveId
	请假人ID（用户ID） leavemanId
	请假内容 leaveContent
	请假开始时间 startTime
	请假结束时间 endTime
	请假状态（0：待上级审批，1待顶级审批，2已审批） leaveState
	请假结果（0：待审核，1：通过，2：未通过）leavereSults
	上级ID leadId*/
	public Integer leaveId;
	public String leavemanId;
	public String leaveContent;
	public Date startTime;
	public Date endTime;
	public String leavereSults;
	public String leadId;
	public Integer getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}
	public String getLeavemanId() {
		return leavemanId;
	}
	public void setLeavemanId(String leavemanId) {
		this.leavemanId = leavemanId;
	}
	public String getLeaveContent() {
		return leaveContent;
	}
	public void setLeaveContent(String leaveContent) {
		this.leaveContent = leaveContent;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getLeavereSults() {
		return leavereSults;
	}
	public void setLeavereSults(String leavereSults) {
		this.leavereSults = leavereSults;
	}
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	
	@Override
	public String toString() {
		return "LeaveVo [leaveId=" + leaveId + ", leavemanId=" + leavemanId + ", leaveContent=" + leaveContent
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", leavereSults=" + leavereSults + ", leadId="
				+ leadId + "]";
	}
	public LeaveVo(Integer leaveId, String leavemanId, String leaveContent, Date startTime, Date endTime,
		 String leavereSults, String leadId) {
		super();
		this.leaveId = leaveId;
		this.leavemanId = leavemanId;
		this.leaveContent = leaveContent;
		this.startTime = startTime;
		this.endTime = endTime;
		this.leavereSults = leavereSults;
		this.leadId = leadId;
	}
	public LeaveVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
