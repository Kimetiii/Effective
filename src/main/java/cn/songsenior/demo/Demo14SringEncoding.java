package cn.songsenior.demo;

import java.util.Arrays;

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
 * 820. 单词的压缩编码 LeetCode_0820
 */

public class Demo14SringEncoding {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] str = {"time", "me", "ball"};
		int i = solution.minimumLengthEncoding_1(str);
		System.out.println(i);

	}

	static class Solution {
		public int minimumLengthEncoding_1(String[] words) {
			// 按长度降序排序
			Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
			StringBuilder sb = new StringBuilder();
			for (String s : words) {
				if (sb.indexOf(s + "#") == -1) {
					sb.append(s).append("#");
				}
			}
			return sb.length();
		}

		/**
		 * @author ZhouJie
		 * @date 2020年3月29日 上午1:33:22
		 * @Description: 辅助索引节点
		 */
		class TrieNode {
			TrieNode[] next = new TrieNode[26];
		}

		/**
		 * @author: ZhouJie
		 * @date: 2020年3月29日 上午1:33:24
		 * @param: @param words
		 * @param: @return
		 * @return: int
		 * @Description: 2-Trie，建立字典索引
		 */
		public int minimumLengthEncoding_2(String[] words) {
			// 按长度降序排序
			Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
			int minLen = 0;
			// 根索引
			TrieNode root = new TrieNode();
			for (String s : words) {
				// 每次都从根开始搜索
				TrieNode currNode = root;
				// 当前单词是否需要单独新建索引
				boolean f = false;
				for (int i = s.length() - 1; i > -1; i--) {
					// 细节， s.charAt(i) - 'a'即得到0-25对应到数组索引
					int index = s.charAt(i) - 'a';
					// 当前字符是否已建立索引，若未建立索引则新建索引并更新布尔值
					if (currNode.next[index] == null) {
						f = true;
						currNode.next[index] = new TrieNode();
					}
					// 搜索下一个单词索引
					currNode = currNode.next[index];
				}
				if (f) {
					// 记录新建索引增加的长度
					minLen += s.length() + 1;
				}
			}
			return minLen;
		}
	}
}
