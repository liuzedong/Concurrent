package com.lzd.two.synchronizedOneThreadIn;
/**
 * B线程进行调用同步代码块，进行测试
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class ThreadB extends Thread{
	
	private ObjectService service;

	public ThreadB(ObjectService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.serviceMethod();
	}
	
}
