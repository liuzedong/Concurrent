package com.lzd.two.synchronizedbad;
/**
 * 证明synchronized关键字声明的弊端，当一个线程，在同步代码块中执行的时间过长
 * 另外一个线程就必须等待该线程执行完毕
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class Task {

	private String getData1;
	private String getData2;
	
	public synchronized void doLong(){
		try {
			System.out.println("begin task");
			Thread.sleep(3000);
			getData1 = "长时间处理任务后从远程返回的值 1 threadNmae = " + Thread.currentThread().getName();
			getData2 = "长时间处理任务后从远程返回的值 2 threadName = " + Thread.currentThread().getName();
			System.out.println(getData1);
			System.out.println(getData2);
			System.out.println("end task");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
