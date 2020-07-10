package cn.songsenior.demo;

import java.util.Scanner;

/**
 * 连续整数之和
 * 一个正整数有可能可以被表示为 m(m>1)个连续正整数之和：15=1+2+3+4+5
 * 判断给定的整数 n 能否表示成连续的 m(m>1)个正整数之和
 * <p>
 * 示例：
 * 输入：15
 * 输出：YES
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
