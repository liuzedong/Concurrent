package com.lzd.two.synNotExtends;
/**
 * 继承Main类中的同步方法，但是同步是可以继承的
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class Sub extends Main{

	
	@Override
	public void serviceMethod() {
		try {
			System.out.println("int sub 下一步 sleep begin threadName = " + Thread.currentThread().getName()
					+ " time = " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int sub 下一步 sleep end threadName = " + Thread.currentThread().getName()
					+ " time = " + System.currentTimeMillis());
			super.serviceMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// 此处 必须自己添加sysnchronized关键字
	/*@Override
	synchronized public void serviceMethod() {
		try {
			System.out.println("int sub 下一步 sleep begin threadName = " + Thread.currentThread().getName()
					+ " time = " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int sub 下一步 sleep end threadName = " + Thread.currentThread().getName()
					+ " time = " + System.currentTimeMillis());
			super.serviceMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}*/

}
