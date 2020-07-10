package cn.songsenior.demo;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 绝地求生
 * 某日 小明乘坐的轮船在大海中翻船 幸运的是小明和其他一共N人抓住并搭上了一艘救生船
 * 但又不幸的是救生船上的水和食物只够一个人漂流到海岸。
 * 为了生存，大家决定玩一个游戏 N个人围成一个圈，从第一个位置开始报数，报到M后该位置的人就跳下大海。
 * 接着从M-1位置的人重新开始报数，直到救生船上只剩一个人为止。
 * 如 N=6，M=5 跳海的位置顺序是5，4，6，2，3，最终只有一个位置的人幸存。
 * 小明的求生欲很强 在得知 N和 M 后，小明应该排在哪个位置？
 * <p>
 * 输入描述：
 * 输入两个整数 N(2<=N<=100和 M（1<=M<=100）以逗号分隔，分别表示救生船上起始人数和每轮报数次数。
 * 输出描述：
 * 能幸存的位置编号
 * <p>
 * 示例：
 * 输入：6，5
 * 输出：1
 */

public class Demo16LastDance {
	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner scanner = new Scanner(System.in);
		String[] split = scanner.nextLine().split(",");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		System.out.println(getLastMan(n, m));
	}

	private static int getLastMan(int n, int m) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int index = m - 1;
		while (list.size() != 0) {
			index = index % list.size();
			list.remove(index);
			index += m - 1;
			if (list.size() == 1) {
				return list.get(0);
			}
		}
		return -1;
	}

}
