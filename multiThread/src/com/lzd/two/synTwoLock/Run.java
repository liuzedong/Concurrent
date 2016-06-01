package com.lzd.two.synTwoLock;
/**
 * 运行结果为， 异步调用的，不是同步的，因为一个是对象锁，一个是Class锁
 * 证明持有的是不同的锁
 * @date 2016年6月1日
 * @author lzd
 *
 */
public class Run {
	
	public static void main(String[] args) {
		Service service = new Service();
		ThreadA a = new ThreadA();
		a.setName("A");
		a.start();
		
		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();
		
		ThreadC c = new ThreadC(service);
		c.setName("C");
		c.start();
	}

}
