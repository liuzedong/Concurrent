package com.lzd.two.synchronizedMethodLockObject;
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
}
