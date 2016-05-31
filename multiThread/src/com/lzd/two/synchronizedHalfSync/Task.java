package com.lzd.two.synchronizedHalfSync;
/**
 * 该类，用来实现使用同步代码块，来提高同步的效率
 * 一半同步，一半异步，在同步代码块中的数据为同步的，不在其中的为异步调用
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class Task {

	public void doLongTimeTask(){
		for (int i = 0; i < 100; i++) {
			System.out.println("nosynchronized threadName = " + Thread.currentThread().getName()
					+ ",i = " + (i+1));
		}
		System.out.println("");
		synchronized(this){
			for (int i = 0; i < 100; i++) {
				System.out.println("synchronized threadName = " + Thread.currentThread().getName()
						+ ",i = " + (i+1));
			}
		}
	}
}
