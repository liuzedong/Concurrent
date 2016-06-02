package com.lzd.two.StringAndSyn;
/**
 * 创建两个线程，传入同样的字符串，这个字符串会再常量池中，所以相等，看看线程是否同步
 * 结果：使用的是同一个锁，后一个锁 会等待第一个锁执行完成，才能执行
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
