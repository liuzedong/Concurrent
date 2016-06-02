package com.lzd.two.twoStop;
/**
 * 运行两个线程，第一个线程会进行死锁，第二个线程 会一直等待
 * @date 2016年6月2日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		Service service = new Service();
		ThreadA a = new ThreadA(service);
		a.start();
		
		ThreadB b = new ThreadB(service);
		b.start();
	}
}
