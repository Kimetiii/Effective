package cn.songsenior.demo;

import java.util.Scanner;

/**
 * N阶楼梯的走法
 */
public class Demo02Stairs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正整数");
		int num = sc.nextInt();
		int sum = getSum(num);
		System.out.println(sum);
	}

	public static int getSum(int n) {
		if (n <= 2) {
			return n;
		}
		int pre2 = 2;
		int pre1 = 1;
		for (int i = 3; i < n; i++) {
			int next = pre1 + pre2;
			pre1 = pre2;
			pre2 = next;
		}
		return pre2;
	}
}
