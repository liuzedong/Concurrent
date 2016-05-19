package com.lzd.one.test;

import com.lzd.one.mythread.MyThread5;

/**
 * 实例变量与线程安全
 * 线程之间共享数据的情况
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread5 {

	public static void main(String[] args) {
		MyThread5 mythread = new MyThread5();
		Thread a = new Thread(mythread, "A");
		Thread b = new Thread(mythread, "B");
		Thread c = new Thread(mythread, "C");
		Thread d = new Thread(mythread, "D");
		Thread e = new Thread(mythread, "E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
}
