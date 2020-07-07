package cn.songsenior.demo;

import java.util.Scanner;

/**
 * 连续整数之和
 */
public class Demo01SumInt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正整数");
		int num = sc.nextInt();
		String flag = "NO";
		int sum = 0;
		for (int n = 0; n < num; n++) {
			for (int i = n + 1; i < num; i++) {
				if (addNum(i, n) == num)
					flag = "YES";
			}
		}
		System.out.println(flag);
	}
	public static int addNum(int n, int min) {
		if (n == min)
			return min;
		else return n + addNum(n - 1, min);
	}
}
