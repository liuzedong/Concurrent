package com.lzd.one.test;

import com.lzd.one.mythread.MyThread11;

/**
 * 运行MyThread11 这个类
 * @date 2016年5月22日
 * @author lzd
 */
public class Run_MyThread11 {

	public static void main(String[] args) {
		try {
			MyThread11 thread = new MyThread11();
			thread.start();
			Thread.sleep(200);
			thread.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main方法进入catch");
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
