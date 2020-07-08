package cn.songsenior.demo;

import java.util.Scanner;

/**
 * 语句倒排
 * 输入一个单词语句 每个单词是以26个大写或者小写英文字母构成，
 * '-' 做为单词连接符使用时 视为单词的一部分，但在一个单词中只能连续一次，
 * 连续出现两个 '-' 以上时视为分隔符
 * 非构成单词的字符均视为单词间隔符 要求倒排后的单词间隔符以空格表示，
 * 原字符串中相邻单词间有多个间隔符时，倒排转换后单词间只允许出现一个空格间隔符
 * 每个单词最长20个字母
 */

public class Demo15StringReverse {
	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner scanner = new Scanner(System.in);
		System.out.println(getReverseStr(scanner.nextLine()));
	}

	public static String getReverseStr(String text) {
		// 正则替换所有非字母的连续重复的字符
		text = text.replaceAll("[^a-zA-Z]{2,}", " ");
		// 优化开头结尾出现的'-'
		text = text.replaceAll("^-", " ");
		text = text.replaceAll("-$", " ");
		// 非构成单词的字符均视为单词间隔符
		String[] split = text.split("[^a-zA-Z\\-]");
		// 倒排
		StringBuilder sb = new StringBuilder();
		for (int i = split.length - 1; i >= 0; i--) {
			sb.append(split[i]).append(" ");
		}
		// trim
		return sb.toString().trim();
	}
}
