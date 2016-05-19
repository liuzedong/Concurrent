package com.lzd.one.test;
/**
 * 查看当前线程的名称，当运行一个类时，就是在运行一个线程
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Test {
	
	public static void main(String[] args) {
		System.out.println("当前线程名称：" + Thread.currentThread().getName());
	}

}
