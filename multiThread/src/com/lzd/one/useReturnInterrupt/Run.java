package com.lzd.one.useReturnInterrupt;
/**
 * 测试return停止线程的启动类
 * 这个线程2秒后，停止了
 * @date 2016年5月23日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyThread thread = new MyThread();
		thread.start();
		Thread.sleep(2000);
		thread.interrupt();
		
	}
}
