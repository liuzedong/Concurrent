package com.lzd.two.synMoreObjectStaticOneLock;
/**
 * 调用类中的静态方法，但是是创建类进行调用
 * @date 2016年6月1日
 * @author lzd
 *
 */
public class ThreadA extends Thread{
	
	private Service service;

	public ThreadA(Service service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		super.run();
		service.printA();
	}

}
