package com.lzd.two.synNotExtends;
/**
 * 测试子类会不会继承父类的线程同步功能
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		Sub sub = new Sub();
		ThreadA a = new ThreadA(sub);
		ThreadB b = new ThreadB(sub);
		a.setName("a");
		b.setName("b");
		a.start();
		b.start();
	}
}
