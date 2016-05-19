package com.lzd.one.mythread;
/**
 * 实例变量与线程安全
 * 线程间不共享数据的情况
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class MyThread4 extends Thread{

	private int count = 5;
	
	public MyThread4(String name){
		this.setName(name);		// 设置线程的名称
	}
	
	@Override
	public void run() {
		super.run();
		while (count > 0){
			count--;
			System.out.println(" 由 " + this.currentThread().getName() + " 计算，count = " + count);
		}
	}

}
