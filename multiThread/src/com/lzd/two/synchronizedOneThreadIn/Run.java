package com.lzd.two.synchronizedOneThreadIn;
/**
 * 同步代码块的synchronized(this)的启动类
 * 但是执行的结果和  同步方法是相同的，并没有提高什么效率
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class Run {
	
	public static void main(String[] args) {
		ObjectService service = new ObjectService();
		ThreadA a = new ThreadA(service);
		a.setName("a");
		a.start();
		
		ThreadB b = new ThreadB(service);
		b.setName("b");
		b.start();
	}

}
