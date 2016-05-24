package com.lzd.one.daemonThread;
/**
 * 查看守护进程是在上面时候，结束的
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			// 将该线程，置为 守护进程
			thread.setDaemon(true);
			thread.start();
			Thread.sleep(5000);
			
			System.out.println("我离开thread对象也不再打印了，也就是停止了");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
