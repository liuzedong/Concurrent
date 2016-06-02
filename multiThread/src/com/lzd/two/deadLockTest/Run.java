package com.lzd.two.deadLockTest;
/**
 * 多线程的死锁现象展示
 * @date 2016年6月2日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args)  {
		try{
			DealThread t1 = new DealThread();
			t1.setFlag("a");
			Thread thread1 = new Thread(t1);
			thread1.start();
			Thread.sleep(100);
			
			t1.setFlag("b");
			Thread thread2 = new Thread(t1);
			thread2.start();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
