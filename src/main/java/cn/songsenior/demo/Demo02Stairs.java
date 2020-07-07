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
		switch (n) {
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			default:
				return getSum(n - 1) + getSum(n - 2) + getSum(n - 3);
		}
	}
}
