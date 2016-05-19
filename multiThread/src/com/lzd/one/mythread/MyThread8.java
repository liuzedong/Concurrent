package com.lzd.one.mythread;
/**
 * 停止不了的线程
 * 该实例，使用interrupt()方法来停止线程，但是interrupt()方法的使用不像
 * for+break那样，马上就能停止的，只是在当前线程中打了一个停止标记
 * 这里不推荐使用stop，suspend和resume等方法进行线程停止
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class MyThread8 extends Thread{

	@Override
	public void run() {
		long b = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i = " + (i+1));
		}
		long e = System.currentTimeMillis();
		System.out.println(e-b);
	}

}
