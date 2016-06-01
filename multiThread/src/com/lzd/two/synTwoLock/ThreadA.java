package com.lzd.two.synTwoLock;
/**
 * 直接调用 类中的静态同步方法
 * @date 2016年6月1日
 * @author lzd
 *
 */
public class ThreadA extends Thread{

	@Override
	public void run() {
		super.run();
		Service.printA();
	}

}
