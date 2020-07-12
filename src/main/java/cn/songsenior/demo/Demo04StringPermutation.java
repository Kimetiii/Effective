package cn.songsenior.demo;

import java.util.*;

/**
 * 字符串排列组合
 * 给定一个只包含大写英文字母的字符串S，要求你给出对S重新排列的所有不相同的排列数。
 * <p>
 * 输入一个长度不超过10的字符串S 确保都是大写的
 * 输出S重新排列的所有不相同的排列数 包含自己本身
 */
public class Demo04StringPermutation {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char[] chars = s.nextLine().toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int num = 0;
		for (char ch:chars) {
			if(null == map.get(ch)) {
				num = 0;
			} else {
				num = map.get(ch);
			}
			map.put(ch,num + 1);
		}
		int allSort = SortOne(chars.length);
		for (char key : map.keySet()) {
			allSort = allSort/SortOne(map.get(key));
		}
		System.out.println(allSort);
	}

	static int SortOne (int charsnum) {
		if (charsnum == 1) {
			return 1;
		}
		return charsnum * SortOne(charsnum - 1);
	}


}
