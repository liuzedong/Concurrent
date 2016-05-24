package com.lzd.one.mythread;
/**
 * yield方法，的作用是放弃当前线程的CPU资源，将它让给其他任务去占用CPU执行时间。
 * 但放弃的时间不确定，有可能刚刚放弃，有马上又获得CUP的时间片
 * 这个代码，如果打开注解，Thread.yield()方法，会比没打开慢些
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class MyThread14 extends Thread{

	public void run(){
		long begintime = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < 50000000; i++) {
			Thread.yield();
			count = count + (i + 1);
			
		}
		long endtime = System.currentTimeMillis();
		System.out.println("总共消耗的时间：" + (endtime - begintime));
	}
}
