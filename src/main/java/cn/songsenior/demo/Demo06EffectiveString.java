package cn.songsenior.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 有效字符串
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 字符的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Demo06EffectiveString {
	public static void main(String[] args) {
		//只要字符串中任意两个相邻字符是此集合中的一个，即不符合，无效；
		String[] wuxiaoku = {"[)", "[}", "(]", "(}", "{]", "{)"};
		//只要字符串中首字符是此集合中的一个，即不符合，无效；
		String[] wuxiaoshou = {")", "]", "}"};
		//只要字符串中尾字符是此集合中的一个，即不符合，无效；
		String[] wuxiaowei = {"(", "[", "{"};
		List<String> wuxiaokulist = Arrays.asList(wuxiaoku);
		List<String> wuxiaoshoulist = Arrays.asList(wuxiaoshou);
		List<String> wuxiaoweilist = Arrays.asList(wuxiaowei);
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			boolean flag = true;
			String s = sc.nextLine();
			if (s.isEmpty()) {
				System.out.println(true);
				continue;
			} else {
				if (wuxiaoshoulist.contains(s.substring(0, 1)) || wuxiaoweilist.contains(s.substring(s.length() - 1))) {
					//只要字符串中首字符是无效首字符集合中的一个，或者字符串中尾字符是无效尾集合中的一个，即不符合，无效；
					System.out.println(false);
					continue;
				}
				char[] chars = s.toCharArray();
				int xiaoyou = 0, xiaozuo = 0;
				int zhongyou = 0, zhongzuo = 0;
				int dayou = 0, dazuo = 0;
				for (char aChar : chars) {
					if (aChar == '(') {
						xiaozuo++;
					}
					if (aChar == ')') {
						xiaoyou++;
					}
					if (aChar == '[') {
						zhongzuo++;
					}
					if (aChar == ']') {
						zhongyou++;
					}
					if (aChar == '{') {
						dazuo++;
					}
					if (aChar == '}') {
						dayou++;
					}
				}
				if (xiaozuo != xiaoyou || zhongzuo != zhongyou || dazuo != dayou) {
					//只要同一类型括号左右括号的数量不等则不符合，无效；
					System.out.println(false);
					continue;
				} else {
					//若同一类型括号左右括号的数量均对应相等，继续判断；
					String j;
					for (int i = 0; i < s.length() - 1; i++) {
						if (s.length() == 2) {
							j = s;
						} else {
							if (i == s.length() - 2) {
								j = s.substring(i);
							} else {
								j = s.substring(i, i + 2);
							}
						}
						if (wuxiaokulist.contains(j)) {
							//只要字符串中任意两个相邻字符是无效库集合中的一个，即不符合，无效；
							flag = false;
							break;
						}
					}
				}
			}
			System.out.println(flag);
		}
	}

}
