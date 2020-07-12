package cn.songsenior.demo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串编码
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * <p>
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * <p>
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * <p>
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * <p>
 * 1. 1<=words.length<=200
 * 2. 1<=words[i].length<=7
 * 3. 每个单词都是小写字母
 * <p>
 * 示例：
 * 输入：time,me,ball
 * 输出：10
 * 820. 单词的压缩编码 LeetCode_0820
 */

public class Demo14SringEncoding {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		System.out.println(getEncodeLength(text));
	}

	private static int getEncodeLength(String text) {
		String[] split = text.split(",");
		Arrays.sort(split, (s1, s2) ->
				s2.length() - s1.length()
		);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			if (sb.indexOf(split[i]) == -1) {
				sb.append(split[i] + "#");
			}
		}
		System.out.println(sb.toString());
		return sb.length();
	}

}
