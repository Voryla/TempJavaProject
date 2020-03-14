package com.zwk.sort;

import org.junit.Test;

public class BubbleSort {
	// 冒泡排序
	@Test
	public void bubbleSort() {
		int js = 0;
		int[] arr = {12, 3, 5, 9, 8, 2, 7, 4, 3, 60, 35, 1};
		int temp;//定义一个临时变量
		for (int i = 0; i < arr.length - 1; i++) {//冒泡趟数
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					SortTool.swap(arr,j,j+1);
				}
				js++;
			}
		}
		SortTool.printNumbers(arr);
	}
}
