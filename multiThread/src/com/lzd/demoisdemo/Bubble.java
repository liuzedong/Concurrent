package com.lzd.demoisdemo;

import java.util.Arrays;

/**
 * 冒泡算法的实现
 * @date 2016年10月21日
 * @author lzd
 *
 */
public class Bubble {
	
	/**
	 * 冒泡排序
	 * @param array 需要排序的数字
	 * @return
	 * @author 刘泽栋 2016年10月21日 下午3:29:18
	 */
	public static int[] sort(int[] array){
		// 用来保存临时数字的
		int temp ;
		
		// 第一层循环表明比较的轮数，比如length个元素，比较轮数为length - 1（不需要和自己比较）
		for (int i=0; i<array.length-1; i++ ){
			System.out.println("第" + (i+1) + "轮开始啦");
			// 第二层循环，每个相邻的两个比较一次，次数随着轮数的增加不断增加，每轮确定一个最大的
			for (int j=0; j<array.length-1; j++){
				if (array[j+1] < array[j]){
					temp = array[j];
					array[j] = array[j+1];
					array[j + 1] = temp;
				}
				System.out.println("第" + (i+1) + "轮，第" + (j+1) + "此比较：");
				System.out.println(Arrays.toString(array));
			}
			
			
			
		}
		
		
		
		
		
		return null;
	}
	
	
	public static void main(String[] args) {
		int[] array = {2,4,1,33,22,55,23};
		sort(array);
	}
}
