package com.lzd.two.setNewStringTwoLock;
/**
 * 创建两个线程
 * @date 2016年6月11日
 * @author lzd
 *
 */
public class ThreadB extends Thread{

	private MyService myService;

	public ThreadB(MyService myService) {
		super();
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.testMethod();
	}
	
	
}
