package com.lzd.two.synNotExtends;
/**
 * 创建B线程，然后调用Sub的同步的方法，测试是否会继承 同步
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class ThreadB extends Thread{
	private Sub sub;

	public ThreadB(Sub sub) {
		super();
		this.sub = sub;
	}

	@Override
	public void run() {
		super.run();
		sub.serviceMethod();
	}
	
	
}
