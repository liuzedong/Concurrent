package com.lzd.two.setNewStringTwoLock;
/**
 * 没有休眠，所以锁都是"123"
 * 所以是同步的，会等待现象A先运行完成，再运行B线程
 * @date 2016年6月11日
 * @author lzd
 *
 */
public class Run2 {

	public static void main(String[] args) {
		MyService service = new MyService();
		// 创建线程A
		ThreadA a = new ThreadA(service);
		a.setName("A");
		
		// 创建线程B
		ThreadB b = new ThreadB(service);
		b.setName("B");
		
		// 开启线程A后，休眠50微秒，开启线程B
		a.start();
		b.start();
	}
}
