package com.lzd.two.synchronizedHalfSync;
/**
 * A线程调用，一半同步，一半异步的代码
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class MyThread1 extends Thread{
	
	private Task task;

	public MyThread1(Task task) {
		super();
		this.task = task;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		task.doLongTimeTask();
	}


}
