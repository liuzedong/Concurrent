package com.lzd.one.test;
/**
 * 使用线程的getId()方法，返回线程的唯一标识
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Test2 {
	
	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + " = " + thread.getId());
	}

}
