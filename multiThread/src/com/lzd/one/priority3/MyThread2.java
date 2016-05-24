package com.lzd.one.priority3;

import java.util.Random;

/**
 * 
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class MyThread2 {
	public void run(){
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		for (int i = 0; i < 1000; i++) {
			Random random = new Random();
			random.nextInt();
			addResult = addResult + i;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("☆☆ ☆ ☆     thread 2 use time = " + (endTime - beginTime));
	}
}
