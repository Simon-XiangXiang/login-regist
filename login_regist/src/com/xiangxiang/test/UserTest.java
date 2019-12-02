package com.xiangxiang.test;

import java.util.Scanner;

import com.xiangxiang.dao.UserDao;
import com.xiangxiang.dao.impl.UserDaoImpl;
import com.xiangxiang.game.GuessNumber;
import com.xiangxiang.pojo.User;

/**
 * .������
 * 
 * @author ����
 * @version V1.0
 */
public class UserTest {

	public static void main(String[] args) {
		outer:
		while (true) {

			// ��ӭ����
			System.out.println("---------------�����С����---------------");
			System.out.println("1 ��¼");
			System.out.println("2 ע��");
			System.out.println("3 �˳�");
			System.out.println("���������ѡ��:");
			// ����¼��
			Scanner sc = new Scanner(System.in);
			String chioce = sc.nextLine();
			// �����û���������(�ö�̬,�Ժ������޸�)
			UserDao ud = new UserDaoImpl();
			// �ж�¼������
			switch (chioce) {
			case "1":
				// ��¼����
				System.out.println("---------------��¼����---------------");
				System.out.println("�������û���:");
				String username = sc.nextLine();
				System.out.println("����������:");
				String password = sc.nextLine();

				// ���õ�¼����
				boolean falg = ud.login(username, password);
				
				if (falg) {
					System.out.println("��½�ɹ�");
					break outer;
				} else {
					System.out.println("�û������������,��¼ʧ��,");
				}

				break;
			case "2":
				// ע�����
				System.out.println("---------------ע�����---------------");
				System.out.println("�������û���:");
				String newUsername = sc.nextLine();
				System.out.println("����������:");
				String newPassword = sc.nextLine();
				
				// ���û����������װ��������
				User user = new User(newUsername, newPassword);
				
				//����ע�Ṧ��
				ud.regist(user);
				System.out.println("ע��ɹ�");

				break;
			case "3":
				System.out.println("����������~");
				System.exit(0);
				break;
			default:
				System.out.println("������������ֵ�����Ŷ");
				break;
			}
		}
		System.out.println("�����С��Ϸ��!");
		GuessNumber.start();
	}

}
