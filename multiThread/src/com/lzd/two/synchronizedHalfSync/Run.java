package com.lzd.two.synchronizedHalfSync;
/**
 * 调用一半同步，一半异步的代码
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		Task task = new Task();
		MyThread1 a = new MyThread1(task);
		a.setName("a线程");
		a.start();
		
		MyThread2 b = new MyThread2(task);
		b.setName("b线程");
		b.start();
	}
}
