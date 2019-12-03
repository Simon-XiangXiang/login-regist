package com.xiangxiang.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Poker {

	private Poker() {
		super();

	}

	public static void start() {

		Scanner sc = new Scanner(System.in);

		// װ������
		HashMap<Integer, String> card = new HashMap<Integer, String>();

		// ����ϴ��
		ArrayList<Integer> list = new ArrayList<Integer>();

		// ���廨ɫ����͵�������
		String[] color = { "����", "����", "��Ƭ", "÷��" };
		String[] num = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };

		// ����һ����������ÿ���ƵĴ�С,����ϴ��֮���������
		int index = 0;

		// ����54����
		for (String s1 : num) {
			for (String s2 : color) {
				card.put(index, s2.concat(s1));
				list.add(index);
				index++;
			}
		}
		card.put(index, "С��");
		list.add(index);
		index++;
		card.put(index, "����");
		list.add(index);

		// ϴ��(ϴ���Ǳ��)
		Collections.shuffle(list);

		// ����(����Ҳ�Ǳ��)
		TreeSet<Integer> gaojin = new TreeSet<Integer>();
		TreeSet<Integer> longwu = new TreeSet<Integer>();
		TreeSet<Integer> you = new TreeSet<Integer>();
		TreeSet<Integer> dipai = new TreeSet<Integer>();

		for (Integer i : list) {
			if (i < 3) {
				dipai.add(i);
			} else if (i % 3 == 0) {
				gaojin.add(i);
			} else if (i % 3 == 1) {
				longwu.add(i);
			} else {
				you.add(i);
			}
		}

		// ����
		lookPoker("���", you, card);
		System.out.println("------------------------------------------------");
		System.out.println("�Ƿ�е���?");
		System.out.println("1.�е���                          2.���е���");
		boolean flag = true;
		while (flag) {
			// Integer i = null; ���Ե�û��Ҫ,�˷���Դ
			int i = 0; // �������Ҫ�ȸ���ֵ����,��Ϊtry����Ĵ�����ܻ���������ֵʧ��,����Ҫ��ǰ��ֵ��ֹ�����������
			try {
				i = sc.nextInt();
			} catch (InputMismatchException e) { // �쳣
				System.out.println("�����벻������Ķ���,�����������.�´�Ҫ����Ҫ���䰺~");
				System.exit(0);
			}

			if (i == 1) {
				System.out.println("------------------------------------------------");
				you.addAll(dipai);
				lookPoker("��", dipai, card);
				System.out.println("------------------------------------------------");
				lookPoker("���", you, card);
				flag = false;
			} else if (i == 2) {
				System.out.println("------------------------------------------------");
				System.out.println("�߽����˵���");
				gaojin.addAll(dipai);
				System.out.println("------------------------------------------------");
				lookPoker("��", dipai, card);
				flag = false;
			} else {
				System.out.println("------------------------------------------------");
				System.out.println("������������������");
			}
		}

		System.out.println("------------------------------------------------");
		System.out.println("����ǧ�����˸߽����������");
		System.out.println("------------------------------------------------");
		lookPoker("�߽���", gaojin, card);
		System.out.println("------------------------------------------------");
		lookPoker("�����", longwu, card);
		System.out.println("------------------------------------------------");
		System.out.println("------------------------------------------------");
		System.out.println("���Ƿ���Ӯ��= =?");

	}

	// ����
	public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
		System.out.println(name + "����");
		for (Integer key : ts) {
			System.out.print(hm.get(key) + " ");
		}
		System.out.println();
	}

}
