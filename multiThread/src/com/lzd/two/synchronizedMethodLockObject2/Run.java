package com.lzd.two.synchronizedMethodLockObject2;
/**
 * 查看锁，添加synchronized 关键字和没有添加 ，之间的区别
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		MyObject object = new MyObject();
		ThreadA athread = new ThreadA(object);
		athread.setName("a");
		ThreadB bthread = new ThreadB(object);
		bthread.setName("b");
		
		athread.start();
		bthread.start();
	}
}
