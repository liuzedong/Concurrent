package com.lzd.one.priority3;

import com.lzd.one.priority2.MyThread1;
import com.lzd.one.priority2.MyThread2;

public class Run {
	public static void main(String[] args) {
		for (int i = 0; i < 15; i++) {
			// 设置thread1线程的优先级
			MyThread1 thread1 = new MyThread1();
			thread1.setPriority(5);
			thread1.start();
			
			// 设置thread2线程的优先级
			MyThread2 thread2 = new MyThread2();
			thread2.setPriority(6);
			thread2.start();
		}
	}
}
