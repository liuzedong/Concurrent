package com.lzd.one.test;

import com.lzd.one.mythread.MyThread10;

/**
 * 使用异常来让，线程进行退出
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyThread10 {

	public static void main(String[] args) {
		try{
			MyThread10 thread = new MyThread10();
			thread.start();
			Thread.sleep(2000);	// 先让这个线程运行两秒
			thread.interrupt();	// 通知 线程停止
		}catch(InterruptedException e){
			System.out.println("嘿嘿，我退出了哦");
			e.printStackTrace();
		}
		System.out.println("这个线程结束了");
	}
}
