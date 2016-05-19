package com.lzd.one.test;

import com.lzd.one.mythread.MyThread3;

/**
 * start()的顺序，不代表线程的启动顺序，这个案例进行展示
 * MyThread3的案例
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread3 {

	public static void main(String[] args) {
		MyThread3 mythread1 = new MyThread3(1);
		MyThread3 mythread2 = new MyThread3(2);
		MyThread3 mythread3 = new MyThread3(3);
		MyThread3 mythread4 = new MyThread3(4);
		MyThread3 mythread5 = new MyThread3(5);
		MyThread3 mythread6 = new MyThread3(6);
		MyThread3 mythread7 = new MyThread3(7);
		MyThread3 mythread8 = new MyThread3(8);
		MyThread3 mythread9 = new MyThread3(9);
		MyThread3 mythread10 = new MyThread3(10);
		MyThread3 mythread11 = new MyThread3(11);
		MyThread3 mythread12 = new MyThread3(12);
		MyThread3 mythread13 = new MyThread3(13);
		mythread1.start();
		mythread2.start();
		mythread3.start();
		mythread4.start();
		mythread5.start();
		mythread6.start();
		mythread7.start();
		mythread8.start();
		mythread9.start();
		mythread10.start();
		mythread11.start();
		mythread12.start();
		mythread13.start();
	}
}
