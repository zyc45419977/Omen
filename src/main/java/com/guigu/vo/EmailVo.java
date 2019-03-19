package com.guigu.vo;

public class EmailVo {
	/*邮件编号 emailId
	发件人 emailName
	邮件标题 emailHeadline
	邮件内容 emailContent
	收件人 emailRecipients*/
	public Integer emailId;
	public String emailName;
	public String emailHeadline;
	public String emailContent;
	public String emailRecipients;
	public Integer getEmailId() {
		return emailId;
	}
	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}
	public String getEmailName() {
		return emailName;
	}
	public void setEmailName(String emailName) {
		this.emailName = emailName;
	}
	public String getEmailHeadline() {
		return emailHeadline;
	}
	public void setEmailHeadline(String emailHeadline) {
		this.emailHeadline = emailHeadline;
	}
	public String getEmailContent() {
		return emailContent;
	}
	public EmailVo() {
	
	}
	@Override
	public String toString() {
		return "EmailVo [emailId=" + emailId + ", emailName=" + emailName + ", emailHeadline=" + emailHeadline
				+ ", emailContent=" + emailContent + ", emailRecipients=" + emailRecipients + "]";
	}
	public EmailVo(Integer emailId, String emailName, String emailHeadline, String emailContent,
			String emailRecipients) {
		super();
		this.emailId = emailId;
		this.emailName = emailName;
		this.emailHeadline = emailHeadline;
		this.emailContent = emailContent;
		this.emailRecipients = emailRecipients;
	}
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
	public String getEmailRecipients() {
		return emailRecipients;
	}
	public void setEmailRecipients(String emailRecipients) {
		this.emailRecipients = emailRecipients;
	}
	
}
