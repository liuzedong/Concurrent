package com.lzd.two.doubleSynBlockOneTwo;
/**
 * 两个线程各运行 对象中的一个同步代码块的方法
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
		// TODO Auto-generated method stub
		super.run();
		service.serviceMethodB();
	}
	
}
