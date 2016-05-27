package com.lzd.two.synLockIn_1;
/**
 * 这个是没有死锁发生的情况，可重入锁
 * @date 2016年5月27日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
	}
}
