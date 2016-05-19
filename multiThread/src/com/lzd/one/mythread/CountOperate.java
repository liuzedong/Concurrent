package com.lzd.one.mythread;
/**
 * 案例来测试currentThread()方法，这个方法，返回线程的信息
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class CountOperate extends Thread{

	public CountOperate(){
		System.out.println("CountOperate————begin");
		System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
		System.out.println("this.getName() = " + this.getName());
		System.out.println("CountOperate————end");
	}
	
	@Override
	public void run() {
		System.out.println("run————begin");
		System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
		System.out.println("this.getName() = " + this.getName());
		System.out.println("run————end");
	}

}
