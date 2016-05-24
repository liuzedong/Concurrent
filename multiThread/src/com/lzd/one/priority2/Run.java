package com.lzd.one.priority2;
/**
 * 运行查看线程的规则性，就是优先级
 * 优先级高的 先运行，但是不是全部都运行，所以，只是先运行
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		for (int i = 0; i < 15; i++) {
			// 设置thread1线程的优先级
			MyThread1 thread1 = new MyThread1();
			thread1.setPriority(10);
			thread1.start();
			
			// 设置thread2线程的优先级
			MyThread2 thread2 = new MyThread2();
			thread2.setPriority(1);
			thread2.start();
		}
	}
}
