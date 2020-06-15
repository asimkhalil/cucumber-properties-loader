package com.cucumber.poc.vo;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class UserVO {

	public String userId;
	public String userName;
	public Map parentGroup;
	public String password;

	public UserVO() {
		// this(userId: "", password: "");
	}

	public UserVO(String userId, String password) {
		this.userId = userId;
		this.userName = "";
		this.password = password;
		this.parentGroup = new HashMap();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(Map parentGroup) {
		this.parentGroup = parentGroup;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
