package com.xiangxiang.dao;

import com.xiangxiang.pojo.User;

/**
 * .这是用户操作的接口
 * 
 * @author 翔翔
 * @version V1.0
 */
public interface UserDao {
	/**
	 * .登录功能
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录是否成功
	 */
	public abstract boolean login(String username, String password);
	
	/**
	 * .注册功能
	 * @param user 用户对象(因为注册时填的信息比登录多很多,直接传一个对象比较方便)
	 * @return 注册是否成功
	 */
	public abstract boolean regist(User user);
}
