package cn.songsenior.demo;

import java.util.*;

/**
 * 给定一个只包含大写英文字母的字符串S，要求你给出对S重新排列的所有不相同的排列数。
 * <p>
 * 输入一个长度不超过10的字符串S 确保都是大写的
 * 输出S重新排列的所有不相同的排列数 包含自己本身
 */
public class Demo04StringPermutation {
	public static void main(String[] args) {
		System.out.println("输入一个长度不超过10的字符串");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine().toUpperCase();
			if (!s.isEmpty()) {
				int length = s.length();
				char[] chars = s.toCharArray();
				Arrays.sort(chars);
				Map<Character, Integer> map = new HashMap<Character, Integer>();
				for (int i = 0; i < chars.length; i++) {
					boolean flag = true;
					int num = 1;//该字母的个数；
					while (flag) {
						if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
							if (!(i + 1 < chars.length)) {
								break;
							}
							i++;
							num++;
						} else {
							flag = false;
							map.put(chars[i], num);
						}
					}
				}
				Collection<Integer> values = map.values();
				long pailieshu = getJieChen(length);
				for (int chushu : values) {
					pailieshu = pailieshu / getJieChen(chushu);
				}
				System.out.println(pailieshu);
			}
		}
	}

	public static long getJieChen(int num) {
		long result = 1;
		for (int i = 0; i < num; i++) {
			result = result * (num - i);
		}
		return result;
	}

}
