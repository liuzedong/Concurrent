package com.lzd.one.priority;
/**
 * 运行线程的优先级
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		System.out.println("main线程的优先级 开始：" + Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		System.out.println("main线程的优先级 结束：" + Thread.currentThread().getPriority());
		MyThread1 thread = new MyThread1();
		thread.start();
	}
}
