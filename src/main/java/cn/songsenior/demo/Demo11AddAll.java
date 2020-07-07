package cn.songsenior.demo;

import java.util.Scanner;

/**
 * 给定一个非负整数 num 反复将各个位上的数字相加 直到结果为一位数
 */
public class Demo11AddAll {
	static class Solution {
		int sum = 0;
		public int addDigits(int num) {
			sum = 0;
			while (num > 0) {
				sum += num % 10;
				num = num / 10;
			}
			if (sum > 9)
				addDigits(sum);
			else
				return sum;
			return sum;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("请输入数字");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int i = solution.addDigits(num);
		System.out.println(i);
	}
}
