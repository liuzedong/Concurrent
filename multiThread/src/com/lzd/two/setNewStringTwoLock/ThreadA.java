package com.lzd.two.setNewStringTwoLock;
/**
 * 创建两个线程
 * @date 2016年6月11日
 * @author lzd
 *
 */
public class ThreadA extends Thread{

	private MyService myService;

	public ThreadA(MyService myService) {
		super();
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.testMethod();
	}
	
	
}
