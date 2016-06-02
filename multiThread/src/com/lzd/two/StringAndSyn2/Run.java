package com.lzd.two.StringAndSyn2;
/**
 * 创建的两个线程，传入不同的对象，使用的不是同一把锁，是异步的
 * @date 2016年6月2日
 * @author lzd
 *
 */
public class Run {
	
	public static void main(String[] args) {
		Service service = new Service();
		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();
		
		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();
	}

}
