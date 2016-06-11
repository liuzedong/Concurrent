package com.lzd.two.setNewStringTwoLock;
/**
 * 在将任何数据类型作为同步锁，需要注意的是，是否有多个线程同时持有锁对象，
 * 如果同事持有相同的锁对象，则这些线程之间就是同步的;如果分别获得锁对象，
 * 这些线程之间就是异步的。
 * @date 2016年6月11日
 * @author lzd
 *
 */
public class MyService {

	private String lock = "123";
	public void testMethod(){
		try{
			synchronized(lock){
				System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
				lock = "456";
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
