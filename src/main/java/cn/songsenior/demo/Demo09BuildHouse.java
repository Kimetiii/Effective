package cn.songsenior.demo;

import java.util.Scanner;
import java.util.Vector;

/**
 * 现在有一套积木 包括若干长宽相等 高度不同的长方体房柱和一个房顶 搭建一个房子需要两边等高的房柱和一个房顶
 * 房柱可以拼接 请返回房子可能搭建的最大高度（总高度忽略房顶 提供的房柱无需全部使用）
 * <p>
 * 假如积木里有高度为 1、2、3的房柱
 * 那么可搭建的最大高度为3 其中两边房柱的拼接方式 1+2 3
 * <p>
 * 如果两遍房柱怎么拼接都无法等高 返回0
 * <p>
 * 约束：
 * 1. 0 <= 单个房柱 <=20
 * 2. 1 <= 房柱数量 <=1000
 * 3. 房柱的长度总和最多为5000
 * <p>
 * 输入：积木房柱高度数组
 * 输出：封顶高度
 * <p>
 * 实例：
 * 1、2、3、6 -> 6
 * <p>
 * <p>
 * 1 2 3 4 5 6 6 7
 */

class Main {
	public static void main(String[] args) {
/*		Scanner sc = new Scanner(System.in);
		System.out.println("请输入:");
		String array = sc.nextLine();
		int[] pillars = toInt(array);*/

		partionArray partionArray = new partionArray();
		System.out.println(partionArray.Solution());

	}

	private static int[] toInt(String priceString) {
		String[] str = priceString.split(",");
		int[] result = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			result[i] = Integer.parseInt(str[i]);
		}
		return result;
	}

	private static Integer getMaxHigh(int[] pillars) {
		int sum = 0;
		int memo[][];
		for (int pillar : pillars) {
			sum += pillar;
		}

		if (sum % 2 == 0 && sum != 0) {
			memo = new int[sum / 2 + 1][sum / 2 + 1];
			return 0;
		} else
			return 0;
	}

}

class partionArray {
	private Vector<Integer> arr = new Vector<Integer>();
	private int sum = 0;
	private Scanner iner = new Scanner(System.in);
	private int memo[][];

	public boolean Solution() {
		System.out.print("请输入元素：");
		for (int i = 0; i < 4; ++i) {
			arr.add(i, iner.nextInt());
			sum += arr.elementAt(i);
		}
		// 判断是否能被2整除
		if (sum % 2 == 0 && sum != 0) {
			memo = new int[sum / 2 + 1][sum / 2 + 1];
			return isPartied(arr, 0, sum / 2);
		} else
			return false;

	}

	/**
	 * 对数组中的每个元素采用放与不放
	 * 看那种满足条件
	 * 动态规划等于穷举加剪枝
	 * 剪枝就类似于记忆化--对一些不必要的操作进行简化
	 * 因此用递归时要加上记忆化
	 * 没有记忆化会导致超时
	 *
	 * @param arr
	 * @param Index
	 * @param c
	 * @return
	 */
	public boolean isPartied(Vector<Integer> arr, int Index, int c) {
		if (Index == arr.size() - 1) {
			return c == 0;
		}
		if (c == 0) {
			return true;
		}
		if (memo[Index][c] != 0) {
			return memo[Index][c] == 1;      //在这一步成功的将int类型的值转变为boolean类型的值
		}
		//在这里对接下来的程序进行记忆化拦截
		if (isPartied(arr, Index + 1, c) ||
				isPartied(arr, Index + 1, c - arr.elementAt(Index))) {
			memo[Index][c] = 1;
			return true;
		}
		memo[Index][c] = -1;       //将结果记录下来
		return false;

	}
}

/***
 * 动态规划的写法，自底向上的写法，递推--从一个最优解推出另一个最优解
 * 动态规划问题的核心思想是：
 * 1、要求什么dp数组中就放什么，再去填写dp table
 * 2、要将的大问题分解为一个一个的小问题，例如有多个元素要处理
 * 则先考虑一种情况使其的结果为最优再逐渐推出其他的最优解从而解决问题
 * 所谓的穷举就是把所有的情况都列举出来通过一定的手段去剪枝
 */
class partionArray2 {

	private Vector<Integer> arr = new Vector<Integer>();
	private int sum = 0;
	private Scanner iner = new Scanner(System.in);
	private boolean dp[][];

	public boolean Solution() {
		System.out.print("请输入元素：");
		for (int i = 0; i < 4; ++i) {
			arr.add(i, iner.nextInt());
			sum += arr.elementAt(i);
		}
		if (sum % 2 == 0) {
			int n = sum / 2;
			dp = new boolean[n + 1][n + 1];
			for (int i = 0; i < n; ++i) {
				dp[0][i] = arr.elementAt(0).equals(i);
			}
			for (int i = 1; i < arr.size(); ++i) {
				for (int j = 0; j <= n; ++j) {
					if (j > arr.elementAt(i)) {
						//如果大于的话就看它的dp[i][j]=dp[i-1][j-arr.elementAt(i)]为不为true，如果为true则这个也为true
						dp[i][j] = dp[i - 1][j - arr.elementAt(i)];
					}
					//相等则赋值为true，因为只有在它的子序列中找到一个能正好填满背包的值就可以
					if (j == arr.elementAt(i)) {
						dp[i][j] = true;
					} else {    //小于时保持上一次的值
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
			return dp[arr.size() - 1][n];
		}
		return false;

	}

}



