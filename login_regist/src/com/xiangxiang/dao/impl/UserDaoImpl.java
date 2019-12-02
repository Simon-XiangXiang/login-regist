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
 * .用户操作的具体实现类
 * 
 * @author 翔翔
 * @version V1.0
 * 
 */
public class UserDaoImpl implements UserDao {
	// 为了保证文件一加载就创建
	private static File file = new File("user.txt");
	
	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("创建文件夹失败");
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
				//不能直接用password.hashCode(),它返回int类型不能直接equals
				Integer hashPass = password.hashCode();
				if (datas[0].equals(username) && datas[1].equals(hashPass.toString())) {
					flag = true;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("找不到存放用户登录信息的文件");
		} catch (IOException e) {
			System.out.println("用户登陆失败");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("用户注册释放资源失败");
					// e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public boolean regist(User user) {
		/*
		 * .为了让注册的数据有一定的规则,我就自己定义了一个规则: 用户名=密码的哈希值 .直接存密码不好,存密码的哈希值不会被破解
		 */
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("user.txt"));
			bw.append(user.getUsername() + "=" + user.getPassword().hashCode());
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.out.println("用户注册失败");
			// e.printStackTrace();

		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("用户注册释放资源失败");
					// e.printStackTrace();
				}
			}
		}

		return true;
	}

}
