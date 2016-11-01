package com.lzd.demoisdemo;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入算法的实现，自己动手写，不看别人的代码
 * @date 2016年11月1日
 * @author lzd
 *
 */
public class InsertionSorting2 {
	
	
	public static void main(String[] args) {
		// 创建一个随机的数组，用来后续的排序
		Random r = new Random();
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++){
			nums[i] = r.nextInt(50);
		}
		System.out.println("排序前的结果：" + Arrays.toString(nums));
		
		// 记录当前需要排序的
		int position;
		
		// 循环数组，将这个数组进行排序
		for (int index = 0; index < nums.length; index++){
			// 记录当前的数字
			int key = nums[index];
			position = index;

			// while循环，找到这个数字，需要插入的位置，如果，比较的数字大于前面的一个数字
			// 那么就将这个数字，向前移动一位
			while (position > 0 && nums[position - 1] > key){
				nums[position] = nums[position - 1];
				position --;
			}
			nums[position] = key;
		}
		
		System.out.println("排序后的结果：" + Arrays.toString(nums));
		
	}

}
