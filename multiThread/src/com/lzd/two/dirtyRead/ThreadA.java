package com.lzd.two.dirtyRead;
/**
 * 线程A对 PublicVar对象，进行设置值
 * @date 2016年5月27日
 * @author lzd
 *
 */
public class ThreadA extends Thread{

	private PublicVar publicVar;
	
	
	public ThreadA(PublicVar publicVar) {
		super();
		this.publicVar = publicVar;
	}



	@Override
	public void run() {
		super.run();
		publicVar.setValue("B", "BB");
	}

}
