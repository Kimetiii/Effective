package cn.songsenior.demo;

import java.util.Scanner;

/**
 * 卖水果
 * 给出两个数组 m,n
 * 用 m[i] 代表第i个水果的成本价，n[i] 代表第i个水果能卖出的价钱，加入现在有本钱k元，最多能赚多少钱？
 * 说明：
 * 1. 每种水果只需买一次 只能卖一次
 * 2. 数组m，n大小不超过50
 * 3. 数组元素为正整数，不超过1000
 */
public class Demo03Fruits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正整数");
		String chengBenStr = sc.nextLine();
		String priceStr = sc.nextLine();
		int[] chengBen = toInt(chengBenStr);
		int[] price = toInt(priceStr);
		int money = sc.nextInt();
		System.out.println(getTotal(money, chengBen, price));
	}

	private static int getTotal(int m, int[] c, int[] p) {
		for (int j = 0; j < c.length; j++) {
			for (int i = 0; i < c.length; i++) {
				if (m > c[i]) {
					m += p[i] - c[i];
					c[i] = 1001;
				}
			}
		}
		return m;
	}

	private static int[] toInt(String priceString) {
		String[] str = priceString.split(",");
		int[] result = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			result[i] = Integer.parseInt(str[i]);
		}
		return result;
	}

}
