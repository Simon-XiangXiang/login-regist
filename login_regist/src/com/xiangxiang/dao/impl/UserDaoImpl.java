/**
 * 
 */
package com.xiangxiang.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.xiangxiang.dao.UserDao;
import com.xiangxiang.pojo.User;

/**
 * .�û������ľ���ʵ����
 * 
 * @author ����
 * @version V1.0
 * 
 */
public class UserDaoImpl implements UserDao {
	// Ϊ�˱�֤�ļ�һ���ؾʹ���
	private static File file = new File("user.txt");
	
	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("�����ļ���ʧ��");
			//e.printStackTrace();
		}
	}

	@Override
	public boolean login(String username, String password) {
		boolean flag = false;

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("user.txt"));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] datas = line.split("=");
				//����ֱ����password.hashCode(),������int���Ͳ���ֱ��equals
				Integer hashPass = password.hashCode();
				if (datas[0].equals(username) && datas[1].equals(hashPass.toString())) {
					flag = true;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ�������û���¼��Ϣ���ļ�");
		} catch (IOException e) {
			System.out.println("�û���½ʧ��");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("�û�ע���ͷ���Դʧ��");
					// e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public boolean regist(User user) {
		/*
		 * .Ϊ����ע���������һ���Ĺ���,�Ҿ��Լ�������һ������: �û���=����Ĺ�ϣֵ .ֱ�Ӵ����벻��,������Ĺ�ϣֵ���ᱻ�ƽ�
		 */
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("user.txt"));
			bw.append(user.getUsername() + "=" + user.getPassword().hashCode());
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.out.println("�û�ע��ʧ��");
			// e.printStackTrace();

		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("�û�ע���ͷ���Դʧ��");
					// e.printStackTrace();
				}
			}
		}

		return true;
	}

}
