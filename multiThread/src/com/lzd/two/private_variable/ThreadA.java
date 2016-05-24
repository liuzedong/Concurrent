package com.lzd.two.private_variable;
/**
 * 测试线程安全
 * 私有对象是线程安全的
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class ThreadA extends Thread{
	private HasSelfPrivateNum numRef;
	
	public ThreadA(HasSelfPrivateNum numRef){
		super();
		this.numRef = numRef;
	}
	
	@Override
	public void run(){
		super.run();
		numRef.addI("a");
	}
}
