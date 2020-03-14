package com.zwk.sort;

public class SortTool {
	// 打印数组
	public static void printNumbers(int[] numbers) {
		for (int i : numbers) {
			System.out.print(i+",");
		}
		System.out.println();
	}
	// 交换数组中的两个索引的值
	public static void swap(int[] numbers, int i, int j) {
		int temp=numbers[i];
		numbers[i]=numbers[j];
		numbers[j]=temp;
	}
}
