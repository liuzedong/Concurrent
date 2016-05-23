package com.lzd.one.suspend_resume_LockStop;
/**
 * suspend和resume方法，独占锁的另一个案例，
 * 这个案例是不推荐使用的，会造成项目的问题
 * @date 2016年5月23日
 * @author lzd
 *
 */
public class MyThread extends Thread {

	private long i = 0;
	
	@Override
	public void run() {
		while(true){
			i++;
			System.out.println(i);
		}
	}

}
