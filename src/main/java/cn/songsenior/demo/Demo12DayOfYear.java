package cn.songsenior.demo;

/**
 * 给一个按YYYY-MM-DD格式表示日期字符串date
 * 请你计算并返回该日期是当年的第几天
 */

public  class Demo12DayOfYear {
	public static void main(String[] args) {
		int i = dayOfYear("2020-07-08");
		System.out.println(i);
	}

	private static int dayOfYear(String date) {
		int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] split = date.split("-");

		int day = Integer.parseInt(split[2]);

		int month = Integer.parseInt(split[1]);

		if (isLeapYear(split[0]) && month > 2) {
			day += 1;
		}
		for (int i = 0; i < month - 1; i++) {
			day += arr[i];
		}
		return day;

	}

	private static boolean isLeapYear(String stringYear) {
		int year = Integer.parseInt(stringYear);
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}
}
