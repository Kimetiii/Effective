package cn.songsenior.demo;

import java.util.Scanner;

/**
 * 判断一个数是否是质数
 * <p>
 * 输入 入参
 * 输出 true false
 */
public class Demo10PrimeNumber {
	public static void main(String[] args) {
		boolean isPrime = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正整数");
		int num = sc.nextInt();
		if (num > 0) {
			int k = (int) Math.sqrt(num);//k为num的正平方根，取整数
			for (int i = 2; i <= k; i++) {
				if (num % i == 0) {
					isPrime = false;//不是素数
					break;
				}
			}
		}
		if (isPrime) {
			System.out.println(num + "是素数");
		} else {
			System.out.println(num + "不是素数");
		}

	}

}
