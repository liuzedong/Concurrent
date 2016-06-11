package com.lzd.two.innserTest1;

import com.lzd.two.innserTest1.OutClass.Inner;

/**
 * 运行
 * @date 2016年6月11日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		final Inner inner = new Inner();
		
		// 创建一个线程进行运行
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				inner.method1();
			}
		}, "A");
		
		// 再创建一个线程进行运行
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				inner.method2();
			}
		}, "B");
		
		t1.start();
		t2.start();
	}
}
