package com.lzd.one.mythread;
/**
 * 在沉睡中结束线程，查看效果
 * @date 2016年5月22日
 * @author lzd
 */
public class MyThread11 extends Thread{

	@Override
	public void run() {
		super.run();
		try {
			System.out.println("run begin");
			// 让线程沉睡
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("在沉睡中停止，进入啦catch：" + this.isInterrupted());
			e.printStackTrace();
		}
	}
}
