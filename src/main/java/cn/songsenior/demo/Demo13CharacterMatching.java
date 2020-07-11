package cn.songsenior.demo;

import java.util.Scanner;

/**
 * 字符匹配
 * 给一个字符串s和一个字符规律p,请你来实现一个支持 '.' 和 '*' 的字符匹配
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个字符串's'的 而不是部分字符串
 * <p>
 * s,p 可能为空 小写字母
 */

public class Demo13CharacterMatching {

	public static void main(String[] args) {
		System.out.println("请输入元素：");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String p = scanner.nextLine();
		System.out.println(isMatch(s, p));
	}

	private static boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i <= n; ++i) {
			if (p.charAt(i - 1) == '*') {
				dp[0][i] = true;
			} else {
				break;
			}
		}
		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				} else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}
			}
		}
		return dp[m][n];
	}

}
