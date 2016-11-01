package com.lzd.demoisdemo;

import java.util.Arrays;

/**
 * 插入算法的实现
 * 插入算法是在一个已经排序好的数组上面进行插入一个数字，然后这个数组还是有序的
 * @date 2016年11月1日
 * @author lzd
 *
 */
public class InsertionSorting {

	public static void main(String[] args) {
		// 定义一个排序
		int[] nums = {4,3,-1,9,2,1,8,0,6};
		// 打印没有进行排序的数组
		System.out.println("没有排序前的结果：" + Arrays.toString(nums));
		
		for (int i = 0; i < nums.length; i++){
			// 获得要插入的数字
			int key = nums[i];
			// 获取下标
			int position = i;
			// 循环比较之前排序好的数组，找到合适的位置进行插入
			/**
			 * 这个while循环 中的条件，先是排除第一个元素，然后把获得的这个元素和后面的元素比较
			 * 如果大于前一个数字，那么就将这个数组插入到这个数组的这个数字前面
			 */
			while  (position > 0 && nums[position - 1] > key){
				nums[position] = nums[position -1];
				position --;
			}
			// 找到插入的位置，将数字进行插入
			nums[position] = key;
		}
		// 打印排序后的结果
		System.out.println("排序后的结果：" + Arrays.toString(nums));
	}
	
	
	
}
