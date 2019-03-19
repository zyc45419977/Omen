package com.guigu.vo;

import java.util.Date;

public class WjVo {
	public int fileId;
	public String fileUrl;
	public String fineName;
	public String fineContent;
	public Date fileDate;
	public String userName;
	public String url;
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFineName() {
		return fineName;
	}
	public void setFineName(String fineName) {
		this.fineName = fineName;
	}
	public String getFineContent() {
		return fineContent;
	}
	public void setFineContent(String fineContent) {
		this.fineContent = fineContent;
	}
	public Date getFileDate() {
		return fileDate;
	}
	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "WjVo [fileId=" + fileId + ", fileUrl=" + fileUrl + ", fineName=" + fineName + ", fineContent="
				+ fineContent + ", fileDate=" + fileDate + ", userName=" + userName + ", url=" + url + "]";
	}
	public WjVo(int fileId, String fileUrl, String fineName, String fineContent, Date fileDate, String userName,
			String url) {
		super();
		this.fileId = fileId;
		this.fileUrl = fileUrl;
		this.fineName = fineName;
		this.fineContent = fineContent;
		this.fileDate = fileDate;
		this.userName = userName;
		this.url = url;
	}
	public WjVo() {
	
	}	
}
