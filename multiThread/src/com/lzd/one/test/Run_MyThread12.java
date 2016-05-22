package com.lzd.one.test;

import com.lzd.one.mythread.MyThread12;

/**
 * 运行暴力停止的类
 * @date 2016年5月22日
 * @author lzd
 */
public class Run_MyThread12 {
	
	public static void main(String[] args) {
		try{
			MyThread12 thread = new MyThread12();
			thread.start();
			Thread.sleep(8000);
			// 在8秒后，暴力停止
			thread.stop();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
