package com.lzd.demoisdemo;
/**
 * 使用位移进行计算数据
 * @date 2016年9月20日
 * @author lzd
 *
 */
public class CountNumber {

	public static void main(String[] args) {
		
		int a = 100;
//		int b = a * 12;
//		int c = (a << 3) + (a << 2);
		int b = a / 9;
		int c = a >> 3;
		
		double d = 3;
		double e = 10;
		double result = Math.IEEEremainder(e, d);
		System.out.println(result);
		
		System.out.println("b=" + b + "," + "c=" + c);
		
		
		
	}
	
	
}
