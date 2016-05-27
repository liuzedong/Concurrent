package com.lzd.two.synLockIn_1;

public class MyThread extends Thread{

	
	@Override
	public void run() {
		super.run();
		Service service = new Service();
		service.service1();
	}

}
