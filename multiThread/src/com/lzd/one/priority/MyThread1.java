package com.lzd.one.priority;
/**
 * 线程的优先级，如果 在一个线程中，启动另外一个线程，那么这两个线程是一样的优先级
 * 使用Thread.currentThread.setPriority(int i)来设置  优先级
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class MyThread1 extends Thread{
	
	public void run(){
		// 输出线程的优先级
		System.out.println("MyThread1 run priority = " + this.getPriority());
		MyThread2 thread = new MyThread2();
		thread.start();
	}

}
