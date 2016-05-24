package com.lzd.one.priority2;

import java.util.Random;

/**
 * 线程2 的优先级
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class MyThread2 extends Thread{

	public void run(){
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 50000; j++) {
				Random random = new Random();
				random.nextInt();
				addResult = addResult + i;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("☆☆ ☆ ☆     thread 2 use time = " + (endTime - beginTime));
	}
}
