package com.lzd.one.mythread;

/**
 * 停止线程，使用暴力停止 就是使用stop方法。不推荐使用
 * 这个线程，循环打印1
 * @date 2016年5月22日
 * @author lzd
 */
public class MyThread12 extends Thread {

	private int i;

	@Override
	public void run() {
		super.run();
		try {
			while (true) {
				i++;
				System.out.println("i = " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}