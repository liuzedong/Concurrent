package com.lzd.two.innserTest2;

import com.lzd.two.innserTest2.OutClass.InnserClass1;
import com.lzd.two.innserTest2.OutClass.InnserClass2;

/**
 * 运行
 * @date 2016年6月11日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		final InnserClass1 in1 = new InnserClass1();
		final InnserClass2 in2 = new InnserClass2();
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				in1.method1(in2);
			}
		}, "T1");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				in1.method2();
			}
		}, "T2");
		
		Thread t3 = new Thread(new Runnable(){
			public void run(){
				in2.method1();
			}
		}, "T3");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
