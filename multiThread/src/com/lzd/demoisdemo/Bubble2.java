package com.lzd.demoisdemo;

import java.util.Arrays;

/**
 * 默写 冒泡排序
 * 这个就是冒泡排序的啦。
 * @date 2016年10月21日
 * @author lzd
 *
 */
public class Bubble2 {
	
	
	public static void main(String[] args) {
		int[] array = {6,4,10,4,6,3,6,7,235,643,24,63,2,75,222};
		array = bubbleArray(array);
		
		System.out.println(Arrays.toString(array));
	}
	
	public static int[] bubbleArray(int[] array){
		// 先定义一个  等会使用的临时变量
		int temp ;
		
		// 第一遍，循环，这个循环只是定义，每次遍历需要的次数
		for (int i = 0; i < array.length - 1; i++){
			// 第二变循环，就是将最大的那个数字放到最后去，就是相当于冒泡，把第一个数字放到最后面
			for (int j = 0; j < array.length - 1; j++){
				// 判断，临近的两个数字，那个数字更大，就把那个数字放到后面
				if (array[j] > array[j + 1]){
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		
		// 最后把 这个 排序后的  数组返回回去吧，给你吧
		return array;
	}
	
	

}
