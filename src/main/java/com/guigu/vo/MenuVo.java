package com.guigu.vo;

import java.util.HashMap;
import java.util.Map;

public class MenuVo {

	private Integer id; // ����id

	private String text; // ��ʾ�˵��ı�

	private String url; // �˵���ת��ַ

	private String iconCls; // ��ʾ��ͼ��

	private String state; //

	private Integer pid; // �˵����ڵ�id

	private Map<String, Object> attributes = new HashMap<String, Object>(); // ��ӵ��ڵ���Զ�������

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	private String romestate;
	
	public String getRomestate() {
		return romestate;
	}
	public void setRomestate(String romestate) {
		this.romestate = romestate;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public MenuVo(Integer id, String text, String url, String image, String mstate, Integer pid) {

		this.id = id;
		this.text = text;
		this.url = url;
		this.iconCls = image;
		this.state = mstate;
		this.pid = pid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

}
