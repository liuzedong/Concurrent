package com.lzd.one.test;

import com.lzd.one.mythread.MyThread9;

/**
 * 运行线程
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread9 {

	public static void main(String[] args) throws InterruptedException {
		MyThread9 thread = new MyThread9();
		thread.start();
		Thread.sleep(2000);
		thread.interrupt();
		System.out.println("end");
	}
}
