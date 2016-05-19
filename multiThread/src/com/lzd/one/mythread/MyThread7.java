package com.lzd.one.mythread;
/**
 * 方法isAlive()的案例， 这个方法，是用来返回 线程是否处于活动状态
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class MyThread7 extends Thread{

	@Override
	public void run() {
		System.out.println("run = " + this.isAlive());
	}

}
