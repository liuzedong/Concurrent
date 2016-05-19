package com.lzd.one.mythread;
/**
 * start()的顺序，不代表线程的启动顺序，这个案例进行展示
 * 在Run3中运行
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class MyThread3 extends Thread{

	private int i;
	
	public MyThread3(int i){
		this.i = i;
	}
	
	@Override
	public void run() {
		System.out.println("正在运行的线程:" + i);
	}

}
