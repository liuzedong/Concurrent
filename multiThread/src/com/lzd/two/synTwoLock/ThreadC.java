package com.lzd.two.synTwoLock;
/**
 * 这个是运行非静态的方法
 * @date 2016年6月1日
 * @author lzd
 *
 */
public class ThreadC extends Thread{

	private Service service;
	
	public ThreadC(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.printC();
	}

}
