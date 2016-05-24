package com.lzd.two.twoObjectTwoLock;


/**
 * 测试线程安全，使用的是私有的变量
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class ThreadB extends Thread{

	private HasSelfPrivateNum numRef;

	public ThreadB(HasSelfPrivateNum numRef) {
		super();
		this.numRef = numRef;
	}

	@Override
	public void run() {
		super.run();
		numRef.addI("b");
	}
}
