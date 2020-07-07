package cn.songsenior.demo;

import java.util.Scanner;

/**
 * 字符串重新排列
 * 输入一个字符串，按照字符串里的字母顺序重新输出该字符串 如果输出的字符串包含非字母的字符或者任何其他非法输入 则输出#
 * 字符串最大长度不超过10000
 *
 */
public class Demo07StringReset {
	public static void main(String[] args) {
		char[] str=new char[1000];
		char temp;
		String string,replace = null;
		Scanner sc=new Scanner(System.in);
		System.out.println("输入一个字符串：");
		string=sc.next();
		str=string.toCharArray();
		replace=string;
		while(string.matches("[a-zA-Z]+"))
		{
			for(int i=0;i<string.length();i++)
				for(int j=string.length()-1;j>i;j--)
				{
					if(str[j]<=str[j-1])
					{
						temp=str[j];
						str[j]=str[j-1];
						str[j-1]=temp;
					}
				}
			System.out.println(str);
			System.out.println("输入一个字符串：");
			string=sc.next();
			str=string.toCharArray();
		}
		System.out.println("#");
	}


}
