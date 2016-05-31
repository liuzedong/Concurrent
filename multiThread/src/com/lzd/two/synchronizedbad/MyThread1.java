package com.lzd.two.synchronizedbad;

public class MyThread1 extends Thread{

	private Task task;
	
	public MyThread1(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		CommonUtils.beginTime1 = System.currentTimeMillis();
		task.doLong();
		CommonUtils.endTime1 = System.currentTimeMillis();
	}

}
