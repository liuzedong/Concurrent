package com.lzd.lang;
/**
 * Runtime 类的使用案例，用来看看虚拟机的内存
 * @date 2016年9月29日
 * @author lzd
 *
 */
public class RuntimeDemo {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		
		// 创建数组来消耗内存，看看内存使用情况
		Integer[] freeArray = new Integer[1000000];
		
		// 总内存，返回的是字节单位
		long t = runtime.totalMemory();
		System.out.println("总内存大小 : " + (t /1024/1024) + "M");
		
		// 空闲内存
		long f = runtime.freeMemory();
		System.out.println("空闲内存大小 : " + (f / 1024/ 1024) + "M");
//		System.out.println("空闲内存大小 : " + (f >> 10 >> 10) + "G");
		
		for (int i = 0; i < freeArray.length; i++) {
			freeArray[i] = new Integer(100);
		}
		
		
		// 再次查看空闲内存和总内存
		t = runtime.totalMemory();
		System.out.println("总内存大小 : " + (t /1024/1024) + "M");
		f = runtime.freeMemory();
		System.out.println("空闲内存大小 : " + (f / 1024/ 1024) + "M");
		
		// 释放空间，看看内的大小
		for (int i = 0; i < freeArray.length; i++) {
			freeArray[i] = null;
		}
		
		runtime.gc();
		
		// 再次查看空闲内存和总内存
		t = runtime.totalMemory();
		System.out.println("总内存大小 : " + (t /1024/1024) + "M");
		f = runtime.freeMemory();
		System.out.println("空闲内存大小 : " + (f / 1024/ 1024) + "M");
		
	}
	
	
}
 