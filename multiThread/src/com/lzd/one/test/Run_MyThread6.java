package com.lzd.one.test;

import com.lzd.one.mythread.MyThread6;

/**
 * 实例变量与线程安全
 * 线程之间共享数据的情况
 * 使用synchronized,来修改MyThread5的案例，来实现同步。加锁
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread6 {

	public static void main(String[] args) {
		MyThread6 mythread = new MyThread6();
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
