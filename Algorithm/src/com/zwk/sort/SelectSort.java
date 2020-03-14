package com.zwk.sort;

import org.junit.Test;

// 选择排序
public class SelectSort {
	public static void main(String[] args) {
		//float z = 17 / 14.00f;
		//NumberFormat numberFormat = new DecimalFormat("0.00");
		//System.out.println(numberFormat.format(z));

	}

	/**
	 * 普通版本
	 */
	@Test
	public void testSort() {
		int count = 0;
		int minIndex = 0;
		int[] numbers = {1, 2, 7, 8, 6, 3, 5, 4, 9};
		for (int i = 0; i < numbers.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < numbers.length; j++) {
				minIndex = numbers[j] < numbers[minIndex] ? j : minIndex;
				count++;
			}
			SortTool.swap(numbers, i, minIndex);
		}
		System.out.println(count);
		SortTool.printNumbers(numbers);
	}

	/**
	 * 改进版
	 */
	@Test
	public void testSort_Pro() {
		int[] numbers = {1, 2, 7, 8, 6, 3, 5, 4, 9};
		int count = 0;
		int minIndex = 0;
		int maxIndex = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			minIndex = i;
			maxIndex = numbers.length - 1 - i;
			for (int j = i + 1; j < numbers.length - i; j++) {
				if (numbers[j] < numbers[minIndex]) {
					minIndex = j;
				} else if (numbers[j] > numbers[maxIndex]) {
					maxIndex = j;
				}
				count++;
			}
			SortTool.swap(numbers, minIndex, i);
			SortTool.swap(numbers, maxIndex, numbers.length - i - 1);
		}
		SortTool.printNumbers(numbers);
		System.out.println(count);
	}

}
