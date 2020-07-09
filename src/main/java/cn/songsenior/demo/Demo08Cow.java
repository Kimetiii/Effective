package cn.songsenior.demo;

import java.util.Scanner;

/**
 * 奶牛生小牛
 * 假设农场中成熟的母牛每年都会生一头小母牛 并且永远不会死 第一年有1只小母牛，从第二年开始，母牛又开始生小母牛
 * 小母牛三年之后成熟又可以生小母牛
 * 给定整数 N 求N年后牛的数量
 */
public class Demo08Cow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getAmount(n));
	}

	private static int getAmount(int n) {
		int first = 1;
		int second = 2;
		int last = 3;
		if (n <= 3) {
			return n;
		}
		for (int i = 0; i < n; i++) {
			int temp = first + last;
			first = second;
			second = last;
			last = temp;
		}
		return last;
	}
}

