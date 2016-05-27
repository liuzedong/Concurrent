package com.lzd.two.synLockIn_2;

public class MyThread extends Thread{

	@Override
	public void run() {
		Sub sub = new Sub();
		sub.operateSubMethod();
	}

}
