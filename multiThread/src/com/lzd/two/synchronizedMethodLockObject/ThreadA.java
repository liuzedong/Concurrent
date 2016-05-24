package com.lzd.two.synchronizedMethodLockObject;
/**
 * 创建线程，运行A方法
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class ThreadA extends Thread{

	private MyObject object;

	public ThreadA(MyObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		object.methodA();
	}
	
}
