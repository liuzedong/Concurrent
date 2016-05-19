package com.lzd.one.mythread;
/**
 * 使用继承Thread来创建多线程
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class MyThread1 extends Thread{

	@Override
	public void run() {
		super.run();
		System.out.println("MyThread线程");
	}

}
