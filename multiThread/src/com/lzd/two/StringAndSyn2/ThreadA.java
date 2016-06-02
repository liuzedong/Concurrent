package com.lzd.two.StringAndSyn2;
/**
 * 传入对象，这样就不会使用的同一个锁刘
 * @date 2016年6月2日
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
		service.print(new Object());
	}
	
}
