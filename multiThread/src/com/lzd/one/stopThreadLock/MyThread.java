package com.lzd.one.stopThreadLock;
/**
 * 测试stop停止线程，造成数据的不一致性
 * @date 2016年5月23日
 * @author lzd
 *
 */
public class MyThread extends Thread{

	private SynchronizedObject object;
	
	public MyThread(SynchronizedObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		object.printString("b", "bb");
	}

}
