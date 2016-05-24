package com.lzd.two.synchronizedMethodLockObject2;
/**
 * 创建线程，运行A方法
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class ThreadB extends Thread{

	private MyObject object;

	public ThreadB(MyObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		object.methodB();
	}
	
}
