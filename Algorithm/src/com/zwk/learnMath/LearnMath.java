package com.zwk.learnMath;

import java.util.ArrayList;
import java.util.List;

public class LearnMath {
	public static void main(String[] args){
		System.out.println(getGCD_0(15,6));
	}
	/**
	 * 最大公约数(非递归)
 	 */
	public static int getGCD_0(int num1,int num2) {
		num1 = Math.abs(num1);
		num2 = Math.abs(num2);
		int middle3 = 0;
		while (true) {
			middle3 = num1 % num2;
			if (middle3 == 0)
				break;
			else {
				num1 = num2;
				num2 = middle3;
			}
		}
		return num2;
	}

	/**
	 * 最大公约数(递归)
	 */
	public static int getGCD(int num1, int num2) {
		// 先获得绝对值，保证负数也可以求
		num1 = Math.abs(num1);
		num2 = Math.abs(num2);
		// 先求余数，假定第一个数较大；如果第二个较大，在第二轮调用时会颠倒过来
		int remainder = num1 % num2;
		// 如果为 0，则直接得出
		if (remainder == 0) {
			return num2;
		}
		// 递归调用
		return getGCD(num2, remainder);
	}

	// 素数
	private static void suShu() {
		List<String> suShuList = new ArrayList<String>();

		int num = 1000;
		int j;
		boolean isSushu;
		for (int i = 2; i <= 1000; i++) {
			//备注：这里加上这个判断其实有些时候也不一定会提升性能很明显，加了判断本身也是需要消耗计算机资源。数量比较大，提升会比较明显
			if(i == 1 || (i % 2 == 0 && i != 2 ) )  continue; //偶数和1排除

			isSushu = true;
			for (j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isSushu = false;
					break;
				}
			}
			if (isSushu) {
				suShuList.add(i+"");
			}
		}
		System.out.println("数量：" + suShuList.size());
		System.out.print("元素：");
		for (String str : suShuList) {
			System.out.print( str + "   ");
		}
	}
}
