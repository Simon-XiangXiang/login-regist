package com.xiangxiang.test;

import java.util.Scanner;

import com.xiangxiang.dao.UserDao;
import com.xiangxiang.dao.impl.UserDaoImpl;
import com.xiangxiang.game.GuessNumber;
import com.xiangxiang.pojo.User;

/**
 * .测试类
 * 
 * @author 翔翔
 * @version V1.0
 */
public class UserTest {

	public static void main(String[] args) {
		outer:
		while (true) {

			// 欢迎界面
			System.out.println("---------------翔翔的小程序---------------");
			System.out.println("1 登录");
			System.out.println("2 注册");
			System.out.println("3 退出");
			System.out.println("请输入你的选择:");
			// 键盘录入
			Scanner sc = new Scanner(System.in);
			String chioce = sc.nextLine();
			// 创建用户操作对象(用多态,以后容易修改)
			UserDao ud = new UserDaoImpl();
			// 判断录入内容
			switch (chioce) {
			case "1":
				// 登录界面
				System.out.println("---------------登录界面---------------");
				System.out.println("请输入用户名:");
				String username = sc.nextLine();
				System.out.println("请输入密码:");
				String password = sc.nextLine();

				// 调用登录功能
				boolean falg = ud.login(username, password);
				
				if (falg) {
					System.out.println("登陆成功");
					break outer;
				} else {
					System.out.println("用户名或密码错误,登录失败,");
				}

				break;
			case "2":
				// 注册界面
				System.out.println("---------------注册界面---------------");
				System.out.println("请输入用户名:");
				String newUsername = sc.nextLine();
				System.out.println("请输入密码:");
				String newPassword = sc.nextLine();
				
				// 把用户名和密码封装到对象中
				User user = new User(newUsername, newPassword);
				
				//调用注册功能
				ud.regist(user);
				System.out.println("注册成功");

				break;
			case "3":
				System.out.println("翔翔会想你的~");
				System.exit(0);
				break;
			default:
				System.out.println("不可以输入奇怪的内容哦");
				break;
			}
		}
		System.out.println("来玩个小游戏吧!");
		GuessNumber.start();
	}

}
