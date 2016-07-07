package com.lzd.jdk.demo;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

/**
 * 测试Arrays里面的方法
 * 当数组里面的数字小于47个的时候，那么就是用移位的排序方法
 * @date 2016年6月20日
 * @author lzd
 *
 */
public class ArraysDemo {

	// 总测试类
	@Test
	public void sortTest(){
		int[] sortNum = intRandomArrays();
		
		Arrays.sort(sortNum);
		System.out.println(Arrays.toString(sortNum));
	}
	
	
	// 测试i++的顺序
	@Test
	public void addNumTest(){
		int i = 1;
//		i++;
		++i;
		System.out.println(i);
		
	}
	
	// 测试位移的结果
	@Test
	public void shiftNum(){
		// 需要计算的数字
		int a = 48;
		// 位移数
		int shift = 1;
		System.out.print("位移前：" + Integer.toBinaryString(a) + " >> " + shift + " == ");
		/**
		 * 1010 >> 1 == 0101 >> 1 == 0010 >> 1 == 0001
		 */
		a = a>>>shift;
		System.out.println("位移后：" + Integer.toBinaryString(a));
		System.out.println("结果为：" + a);
		
		
		/*
		 *  256 128 64 32 16 8 4 2 1
		 *  						1 1 0 0 0 1	49
		 *  						0 0 0 1 1 0	6
		 *  32+16=48+1=49
		 */
	}
	
	
	
	// 创建一个随机的int数组
	public static int[] intRandomArrays(){
		int length = 2900;
		
		int[] a = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = new Random().nextInt(100);
		}
		
		
		return a;
	}
	
	@Test
	public void sort_47Test(){
		// 当小于数组小于47个元素的使用 一下方式排序
//		int[] a = new int[]{2,1,5,4};
		//System.out.println(a[1]);
		int[] a = intRandomArrays();
		// 使用移位排序
		int left = 0;
//		int index = 0;
		int right = a.length - 1;
		
		for ( ; left < right; left++) {
			
			// 获取第一个元素
			int ai = a[left + 1];
			while(ai < a[left]){
				// 如果大于，那么 就交换位置
				a[left + 1] = a[left];
				a[left] = ai;
				// 和前面的每一个  数字进行比较
				if(left-- == 0){
					break;
				}
			}
			
			
			
//			System.out.println(left + "  " + right);
		}
		
		System.out.println(Arrays.toString(a));
		
		
		
	}
	
	
	// 插入排序的
	public static void insertion_sort(int[] unsorted){
		for (int i = 1; i < unsorted.length; i++) {
			if(unsorted[i -1] > unsorted[i]){
				int temp = unsorted[i];
				int j = i;
				while(j > 0 && unsorted[j - 1] > temp){
					unsorted[j] = unsorted[j -1];
					j--;
				}
				unsorted[j] = temp;
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int[] a = intRandomArrays();
		insertion_sort(a);
		System.out.println(Arrays.toString(a));
	}
}
