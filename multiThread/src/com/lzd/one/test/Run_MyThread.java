package com.lzd.one.test;

import com.lzd.one.mythread.MyThread;

/**
 * 测试MyThread线程的运行
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread {

	public static void main(String[] args) {
		MyThread mythread = new MyThread();
		mythread.start();
		System.out.println("线程运行结束");
	}
}
