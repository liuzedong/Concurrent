package com.lzd.two.StringAndSyn;
/**
 * 创建两个线程传入同样的字符串
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
		service.print("AA");
	}
	
}
