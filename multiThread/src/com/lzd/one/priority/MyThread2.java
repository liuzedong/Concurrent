package com.lzd.one.priority;
/**
 * 创建一个和MyThread同级的线程
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class MyThread2 extends Thread{
	
	// 输出线程的优先级号码
	public void run(){
		System.out.println("MyThread2 run priority = "  + this.getPriority());
	}

}
