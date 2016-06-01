package com.lzd.two.synStaticMethod;
/**
 * 查看两个线程，别人调用类中的静态方法，查看结果是否同步
 * 
 * 
 * 测试结果是同步的，两个方法 会等待前一个线程，执行完毕，才去向下执行
 * @date 2016年6月1日
 * @author lzd
 *
 */
public class Run {
	
	public static void main(String[] args) {
		ThreadA a = new ThreadA();
		a.setName("A");
		a.start();
		
		ThreadB b = new ThreadB();
		b.setName("B");
		b.start();
		
	}

}
