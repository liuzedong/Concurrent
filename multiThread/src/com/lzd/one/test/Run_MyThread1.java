package com.lzd.one.test;

import com.lzd.one.mythread.MyThread1;

/**
 * 测试MyThread线程的运行
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread1 {

	public static void main(String[] args) {
		MyThread1 mythread = new MyThread1();
		mythread.start();
		System.out.println("线程运行结束");
	}
}
