package com.lzd.two.doubleSynBlockOneTwo;
/**
 * 运行两个线程，然后这两个线程，分别调用  对象中的两个不同代码块，看看，会不会是同步运行的
 * 运行结果为：两个方法会同时阻塞
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class Run {
	
	public static void main(String[] args) {
		ObjectService service = new ObjectService();
		ThreadA a = new ThreadA(service);
		a.start();
		
		ThreadB b = new ThreadB(service);
		b.start();
	}

}
