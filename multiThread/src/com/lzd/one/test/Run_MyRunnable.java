package com.lzd.one.test;

import com.lzd.one.myrunnable.MyRunnable;

/**
 * 运行MyRunnable
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_MyRunnable {
	public static void main(String[] args) {
		Thread myrunnable = new Thread(new MyRunnable());
		myrunnable.start();
		System.out.println("运行结束");
	}
}
