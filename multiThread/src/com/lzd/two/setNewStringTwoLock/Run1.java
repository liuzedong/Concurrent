package com.lzd.two.setNewStringTwoLock;
/**
 * 休眠50毫秒后，线程B获得的锁是"456"，所以是异步的
 * @date 2016年6月11日
 * @author lzd
 *
 */
public class Run1 {

	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		// 创建线程A
		ThreadA a = new ThreadA(service);
		a.setName("A");
		
		// 创建线程B
		ThreadB b = new ThreadB(service);
		b.setName("B");
		
		// 开启线程A后，休眠50微秒，开启线程B
		a.start();
		Thread.sleep(50);
		b.start();
	}
}
