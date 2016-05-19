package com.lzd.one.test;

import com.lzd.one.mythread.MyThread4;

/**
 * 实例变量与线程安全
 * 线程间不共享数据的情况
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread4 {

	public static void main(String[] args) {
		MyThread4 a = new MyThread4("A");
		MyThread4 b = new MyThread4("B");
		MyThread4 c = new MyThread4("C");
		a.start();
		b.start();
		c.start();
	}
	
}
