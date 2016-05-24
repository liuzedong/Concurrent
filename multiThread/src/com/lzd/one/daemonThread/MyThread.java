package com.lzd.one.daemonThread;
/**
 * 守护进程的案例，
 * 守护进程：任何一个守护进程都是整个JVM中所有非守护线程的"保姆"，
 * 		只要当前JVM实例中存在任何一个非守护进程没有结束，守护进程就在工作，
 * 		只有当最后一个非守护进程结束时，守护线程才随着JVM一同结束工作。
 * 守护进程最典型的应用就是GC（垃圾收集器），它是最称职的守护者。
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class MyThread extends Thread{
	private int i = 0;
	
	@Override
	public void run(){
		try {
			while(true){
				i++;
				System.out.println("i = " + (i));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
