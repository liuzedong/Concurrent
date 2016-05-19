package com.lzd.one.test;

import com.lzd.one.mythread.MyThread8;

/**
 * 
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread8_2 {

	public static void main(String[] args) throws InterruptedException {
		MyThread8 mythread = new MyThread8();
		mythread.start();
		Thread.sleep(1000);
		// 实际，是没有停止的
		mythread.interrupt();
		// 停止当前线程
//		Thread.currentThread().interrupt();
		System.out.println("是否停止 1  ：" + mythread.interrupted());
		System.out.println("是否停止 2 ：" + mythread.interrupted());
		System.out.println("end");
	}
}
