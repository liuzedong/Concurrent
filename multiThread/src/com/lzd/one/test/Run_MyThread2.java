package com.lzd.one.test;

import com.lzd.one.mythread.MyThread2;

/**
 * 测试MyThread2的线程不确定性
 * 当前线程和，创建的线程，部分先后顺序的执行
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread2 {
	
	public static void main(String[] args) {
		try{
			MyThread2 mythread = new MyThread2();
			mythread.setName("myThread");
			mythread.start();
			for (int i = 0; i < 10; i++) {
				int time = (int) (Math.random() * 1000);
				Thread.sleep(time);
				System.out.println("main = " + Thread.currentThread().getName());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
