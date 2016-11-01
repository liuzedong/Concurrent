package com.lzd.demoisdemo;

import java.util.Arrays;
import java.util.Random;


/**
 * 快速排序案例2
 * @date 2016年10月24日
 * @author lzd
 *
 */
public class QuickSort02 {
	
	
	public static void main(String[] args) {
		Random r = new Random();
		int[] array = new int[11];
		
		for(int i=0; i<array.length; i++){
			array[i] = r.nextInt(35);
		}
		
		// 快速排序前的数组
		System.out.println("排序前结果：" + Arrays.toString(array));
		
		
		// 进行快速排序
		sort(array, 0, array.length - 1);
		
		
		System.out.println("排序后结果：" + Arrays.toString(array));
	}
	
	/**
	 * 快速排序
	 * @param array 需要排序的数组
	 * @param left 最左边的数字
	 * @param right 最右边的数字
	 * @author 刘泽栋 2016年10月24日 下午8:35:15
	 */
	public static void sort(int[] array, int left, int right){
		// 用来记录，基数的标记位置
		
		if (left < right){
			// 将第一个数字作为基数，然后，把数字分为两边，一边必基数大，一边必基数小
			int divide = array[left];
			// 初始化i, j
			int i = left, j;
			for (j = left+1;j <= right; j++){
				if (array[j] < divide){
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					i++;
				}
			}
			array[left] = array[i];
			array[i] = divide;
			sort(array, left, i - 1);
			sort(array, i + 1, right);
		}
		
		// 将数组进行排序
		
		
		
	}
	
	

}
