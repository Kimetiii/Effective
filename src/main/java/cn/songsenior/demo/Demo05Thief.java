package cn.songsenior.demo;

import java.util.Scanner;

/**
 * 小偷偷东西问题
 * 小偷来到了一个神秘的王宫 突然眼前一亮 发现了五个宝贝 每个宝贝的价值都不一样 且重量也不一样
 * 但是小偷的背包携带重量有限 所以他不得不在宝贝中做出选择 才能使偷到的财富最大
 * <p>
 * 输入描述：
 * 宝贝价值 ——> 3,4,5,4,6
 * 宝贝重量 ——> 2,2,6,5,4
 * 背包容量 ——> 10
 * 输出描述：
 * 偷到的宝贝总价值 ——> 15
 */
public class Demo05Thief {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入:");
		String priceStr = sc.nextLine();
		String weightStr = sc.nextLine();
		int v = sc.nextInt();
		int[] price = toInt(priceStr);
		int[] weight = toInt(weightStr);
		System.out.println(getMaxPrice(5, v, price, weight));
	}

	private static int getMaxPrice(int n, int v, int[] price, int[] weight) {
		int[][] temp = new int[n + 1][v + 1];
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <= v; j++) {
				if (weight[i - 1] > j) {
					temp[i][j] = temp[i - 1][j];
				} else {
					temp[i][j] = Math.max(temp[i - 1][j], temp[i - 1][j - weight[i - 1]] + price[i - 1]);
				}
			}
		}
		return temp[n][v];
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
