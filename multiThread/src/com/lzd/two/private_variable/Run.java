package com.lzd.two.private_variable;
/**
 * 运行两个线程，看看  会不会发生，线程安全的问题
 * 如果类，里面的变量 是使用的  private声明的，那么这个类的变量，是线程安全的
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		HasSelfPrivateNum numRef = new HasSelfPrivateNum();
		ThreadA threadA = new ThreadA(numRef);
		threadA.start();
		
		ThreadB threadB = new ThreadB(numRef);
		threadB.start();
	}
}
