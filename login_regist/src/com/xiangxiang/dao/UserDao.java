package com.xiangxiang.dao;

import com.xiangxiang.pojo.User;

/**
 * .�����û������Ľӿ�
 * 
 * @author ����
 * @version V1.0
 */
public interface UserDao {
	/**
	 * .��¼����
	 * 
	 * @param username �û���
	 * @param password ����
	 * @return ��¼�Ƿ�ɹ�
	 */
	public abstract boolean login(String username, String password);
	
	/**
	 * .ע�Ṧ��
	 * @param user �û�����(��Ϊע��ʱ�����Ϣ�ȵ�¼��ܶ�,ֱ�Ӵ�һ������ȽϷ���)
	 * @return ע���Ƿ�ɹ�
	 */
	public abstract boolean regist(User user);
}
