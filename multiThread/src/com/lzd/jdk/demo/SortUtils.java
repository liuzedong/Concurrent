package com.lzd.jdk.demo;

/**
 * 排序算法的工具类
 * 
 * @date 2016年6月20日
 * @author lzd
 * 
 */
public class SortUtils {

	public static void shiftOperation(int[] a) {
		int left = 0;
		int right = a.length - 1;

		for (int i = 0; i < right; i++) {
			// 获取第一个元素
			int ai = a[i + 1];
			while (ai < a[i]) {
				// 如果大于，那么 就交换位置
				a[i + 1] = a[i];
				a[i] = ai;
				// 和前面的每一个 数字进行比较
				if (i-- == left) {
					break;
				}
			}
		}
	}

}
