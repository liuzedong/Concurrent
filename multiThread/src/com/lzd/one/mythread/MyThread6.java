package com.lzd.one.mythread;
/**
 * 实例变量与线程安全
 * 线程之间共享数据的情况
 * 使用synchronized,来修改MyThread5的案例，来实现同步。加锁
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class MyThread6 extends Thread{

	private int count = 5;
	
	@Override
	synchronized public void run() {
		super.run();
		// 这里不要使用循环语句，因为使用同步后其他线程就得不到运行的机会了，
		// 就会一直由一个线程进行减法运算
		count --;
		System.out.println(" 由 " + this.currentThread().getName() + " 计算，count = " + count);
	}
}
