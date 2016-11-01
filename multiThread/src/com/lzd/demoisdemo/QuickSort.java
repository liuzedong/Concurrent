package com.lzd.demoisdemo;

import java.util.Arrays;

/**
 * 快速排序算法的实现
 * @date 2016年10月24日
 * @author lzd
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int[] map =new int[]{4, 1, 5, 3, 10, 12, 65, 7};
		System.out.println("排序前的结果："+ Arrays.toString(map));
		
		QuickSort qs = new QuickSort();
		qs.sort(map, 0, map.length - 1);
		
		System.out.println("排序后的结果："+ Arrays.toString(map));
		
	}
	
	/**
	 * 将数组进行快速排序
	 * @param map
	 * @param start
	 * @param end
	 * @author 刘泽栋 2016年10月24日 上午11:27:07
	 */
	public void sort(int[] map, int start, int end){
		if (start < end){
			int p = getPlocation(map, start, end);
			sort(map, start, p-1);
			sort(map, p+1, end);
		}
	}
	
	/**
	 * 核心算法，进行快速排序
	 * @param map
	 * @param start
	 * @param end
	 * @return
	 * @author 刘泽栋 2016年10月24日 上午11:29:01
	 */
	public int getPlocation(int[] map, int start, int end){
		int core = map[end];
		int i = start - 1;
		for (int j=start; j<end; j++){
			if (map[j] <= core){
				i++;
				int cache = map[j];
				map[j] = map[i];
				map[i] = cache;
			}
		}
		i++;
		map[end] = map[i];
		map[i] = core;
		
		System.out.println("第"+i+"次排序结果："  + Arrays.toString(map));
		
		return i;
	}
}
