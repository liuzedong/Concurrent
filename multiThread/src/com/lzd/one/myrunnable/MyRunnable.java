package com.lzd.one.myrunnable;
/**
 * Runnable 的入门案例
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "运行");
	}

}
