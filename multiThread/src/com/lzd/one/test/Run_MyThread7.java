package com.lzd.one.test;

import com.lzd.one.mythread.MyThread7;

/**
 * 方法isAlive()的案例， 这个方法，是用来返回 线程是否处于活动状态
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread7 {

	public static void main(String[] args) throws InterruptedException {
		MyThread7 mythread = new MyThread7();
		System.out.println("begin = " + mythread.isAlive());
		mythread.start();
		// 如果不休眠，那么end可能会是true，因为线程完成可能还没完成
		Thread.sleep(1000);
		System.out.println("end = " + mythread.isAlive());
	}
}
