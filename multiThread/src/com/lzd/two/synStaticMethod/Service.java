package com.lzd.two.synStaticMethod;
/**
 * 关键字synchronized可以在应用的static静态方法上，如果这样写了，那么对当前的*.java文件对应的Class类进行持锁
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

}
