package com.xiangxiang.game;


import java.util.Scanner;

/**
 * .����С��Ϸ
 * 
 * @author ����
 * @version V1.0
 * 
 */
public class GuessNumber {
	private GuessNumber() {
	}

	public static void start() {
		int count = 0;
		int num = (int) (Math.random() * 100) + 1;
		// ���ַ���������
		/*
		 * Random r = new Random(); int num = r.nextInt(101);
		 */

		Scanner sc = new Scanner(System.in);

		while (true) {
			count++;
			System.out.println("���������µ���(1-100):");
			int guessNum = sc.nextInt();

			if (guessNum == num) {
				System.out.println("��,���������!ֻ����" + count + "�ξͲ¶��� !");
				break;
			} else if (guessNum > num) {
				System.out.println("�µ�������");
			} else {
				System.out.println("�µ���С��");
			}
		}
		//sc.close()���System.inҲ�ص�,�����Ҫ��System.in,��ô��û��ȫ����ȡ��֮ǰ��Ҫ�ر�Scanner.
		//sc.close();
	}
}
