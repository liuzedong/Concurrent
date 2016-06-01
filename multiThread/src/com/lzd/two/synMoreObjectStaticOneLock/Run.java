package com.lzd.two.synMoreObjectStaticOneLock;
/**
 * 测试结果,是同步的
 * @date 2016年6月1日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		Service s1 = new Service();
		Service s2 = new Service();
		ThreadA a = new ThreadA(s1);
		ThreadB b = new ThreadB(s2);
		a.setName("A");
		b.setName("B");
		a.start();
		b.start();
	}
}
