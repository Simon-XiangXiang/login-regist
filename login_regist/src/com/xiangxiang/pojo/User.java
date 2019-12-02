package com.xiangxiang.pojo;

/**
 * .是用户基本信息类
 * 
 * @author 翔翔
 * @version V1.0
 */
public class User {
	private String username;
	private String password;

	public User() {
		super();

	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
