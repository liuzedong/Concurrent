package com.lzd.two.synTwoLock;
/**
 * 检测本质上的区别，synchronized关键字加到static静态方法上面是给Class类上锁
 * synchronized关键字加在非static静态方法上是给对象加锁
 * @date 2016年6月1日
 * @author lzd
 *
 */
public class Service {
	
	synchronized public static void printA(){
		try {
			System.out.println("线程的名称为：" + Thread.currentThread().getName()
					+ " 在" + System.currentTimeMillis() + " 进入printA");
			Thread.sleep(3000);
			System.out.println("线程的名称为：" + Thread.currentThread().getName()
					+ " 在" + System.currentTimeMillis() + " 离开printA");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized public static void printB(){
		System.out.println("线程的名称为：" + Thread.currentThread().getName()
				+ " 在" + System.currentTimeMillis() + " 进入printB");
		System.out.println("线程的名称为：" + Thread.currentThread().getName()
				+ " 在" + System.currentTimeMillis() + " 离开printB");
	}
	
	// 这个不是静态的方法，注意观察
	synchronized public void printC(){
		System.out.println("线程的名称为：" + Thread.currentThread().getName()
				+ " 在" + System.currentTimeMillis() + " 进入printC");
		System.out.println("线程的名称为：" + Thread.currentThread().getName()
				+ " 在" + System.currentTimeMillis() + " 离开printC");
	}

}
