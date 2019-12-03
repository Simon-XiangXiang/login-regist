package com.xiangxiang.game;


import java.util.Scanner;

/**
 * .猜数小游戏
 * 
 * @author 翔翔
 * @version V1.0
 * 
 */
public class GuessNumber {
	private GuessNumber() {
	}

	public static void start() {
		int count = 0;
		int num = (int) (Math.random() * 100) + 1;
		// 两种方法都可以
		/*
		 * Random r = new Random(); int num = r.nextInt(101);
		 */

		Scanner sc = new Scanner(System.in);

		while (true) {
			count++;
			System.out.println("请输入您猜的数(1-100):");
			int guessNum = sc.nextInt();

			if (guessNum == num) {
				System.out.println("哇,你可真厉害!只猜了" + count + "次就猜对了 !");
				break;
			} else if (guessNum > num) {
				System.out.println("猜的数大了");
			} else {
				System.out.println("猜的数小了");
			}
		}
		//sc.close()会把System.in也关掉,如果非要用System.in,那么在没有全部读取完之前不要关闭Scanner.
		//sc.close();
	}
}
