package com.lzd.two.synMoreObjectStaticOneLock;
/**
 * Class锁可以对类的所有对象实例起作用
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
