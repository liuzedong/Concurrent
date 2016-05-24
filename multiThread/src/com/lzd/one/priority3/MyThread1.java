package com.lzd.one.priority3;

import java.util.Random;

/**
 * 线程优先级具有随机性
 * 如果线程，的优先级，比较接近的话，那么这写线程，之间是随机访问的，不会因为优先级高一点，
 * 就会先运行完成
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class MyThread1 extends Thread{
	public void run(){
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		for (int i = 0; i < 1000; i++) {
			Random random = new Random();
			random.nextInt();
			addResult = addResult + i;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("★ ★ ★ ★     thread 1 use time = " + (endTime - beginTime));
	}
}
