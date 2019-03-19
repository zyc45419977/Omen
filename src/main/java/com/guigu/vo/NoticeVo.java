package com.guigu.vo;

public class NoticeVo {
/*	noticeId  INT(22) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	noticename VARCHAR(50) NOT NULL,
	noticematter VARCHAR(50) NOT NULL,
	noticeissuer*/
	public Integer noticeId;
	public String noticename;
	public String noticematter;
	public String noticeissuer;
	public Integer getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticename() {
		return noticename;
	}
	public void setNoticename(String noticename) {
		this.noticename = noticename;
	}
	public String getNoticematter() {
		return noticematter;
	}
	public void setNoticematter(String noticematter) {
		this.noticematter = noticematter;
	}
	public String getNoticeissuer() {
		return noticeissuer;
	}
	public void setNoticeissuer(String noticeissuer) {
		this.noticeissuer = noticeissuer;
	}
	@Override
	public String toString() {
		return "NoticeVo [noticeId=" + noticeId + ", noticename=" + noticename + ", noticematter=" + noticematter
				+ ", noticeissuer=" + noticeissuer + "]";
	}
	public NoticeVo(Integer noticeId, String noticename, String noticematter, String noticeissuer) {
		super();
		this.noticeId = noticeId;
		this.noticename = noticename;
		this.noticematter = noticematter;
		this.noticeissuer = noticeissuer;
	}
	public NoticeVo() {
		
	}
	
	
}
