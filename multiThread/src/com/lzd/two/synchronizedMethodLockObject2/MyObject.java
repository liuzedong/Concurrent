package com.lzd.two.synchronizedMethodLockObject2;
/**
 * synchronized方法和锁对象
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class MyObject {

	// 添加synchronized 关键字和不添加的，所消耗的时间，使用run方法进行测试
	synchronized public void methodA(){
		try {
			System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 如果没有添加synchronized 关键字，那么两个线程，是可以同步调用的
	// 如果添加，synchronized 关键字，那么其他线程，必须等待，其他加锁方法完成后，才能调用
	synchronized public void methodB(){
		try {
			System.out.println("begin methodB threadName = " + Thread.currentThread().getName() +
					"begin time = " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
