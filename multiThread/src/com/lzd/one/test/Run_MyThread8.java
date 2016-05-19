package com.lzd.one.test;

import com.lzd.one.mythread.MyThread8;

/**
 * 
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread8 {

	public static void main(String[] args) throws InterruptedException {
		MyThread8 mythread = new MyThread8();
		mythread.start();
		Thread.sleep(2000);
		// 实际，是没有停止的
		mythread.interrupt();
	}
}
