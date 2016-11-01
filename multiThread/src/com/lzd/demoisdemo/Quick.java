package com.lzd.demoisdemo;

import java.util.Arrays;

/**
 * 使用快速排序的方式进行排序
 * @date 2016年10月24日
 * @author lzd
 *
 */
public class Quick {
	
	private static int mark = 0;
	
	
	public static void main(String[] args) {
		int[] array = {3, 5, 2, 6, 2};
		System.out.println("排序前的结果："+ Arrays.toString(array));
		
		int[] sorted = sort(array);
		
		// 打印返回结果
		System.out.println("排序后的结果：" + Arrays.toString(sorted));
	}

	/**
	 * 快速排序
	 * @param array
	 * @return
	 * @author 刘泽栋 2016年10月24日 上午10:12:32
	 */
	public static int[] sort(int[] array){
		return quickSort(array, 0, array.length - 1);
	}
	
	/**
	 * 对数组进行快速排序，递归调用
	 * @param array 需排序的数组
	 * @param low 
	 * @param height
	 * @return
	 * @author 刘泽栋 2016年10月24日 上午10:14:57
	 */
	private static int[] quickSort(int[] array, int low, int height){
		if (low < height){
			int division = partition(array, low, height);
			quickSort(array, low, division - 1);
			quickSort(array, division + 1, height);
		}
		return array;
	}
	
	/**
	 * 第一轮分割
	 * @param array
	 * @param low
	 * @param height
	 * @return
	 * @author 刘泽栋 2016年10月24日 上午10:19:28
	 */
	private static int partition(int[] array, int low, int height){
		// 获得第一个基准的数字
		int base = array[low];
		mark ++;
		System.out.println("正在进行第"+ mark +"轮分割，区域："+ low +"-"+height);
		while (low < height){
			while (low < height && array[height] >= base){
				height --;
				System.out.println("从右往左边比"+ base +"小的，指针变动："+ low + "-"+ height);
			}
			swap(array, low, height);
			while (low < height && array[low] <= base){
				low ++;
				System.out.println("从左往右找比"+ base +"大的，指针变动："+ low +"-"+ height);
			}
			swap(array, low, height);
		}
		return low;
	}
	
	/**
	 * 辅助交换方法
	 * @param array
	 * @param a
	 * @param b
	 * @author 刘泽栋 2016年10月24日 上午10:27:06
	 */
	private static void swap(int[] array, int a, int b){
		if (a != b){
			int temp = array[a];
			array[a] = array[b];
			array[b] = temp;
		}
		// 找到符合的，对调
		System.out.println("对调"+ array[a] +"与"+ array[b] +"得到");
		System.out.println(Arrays.toString(array));
	}
	
}
