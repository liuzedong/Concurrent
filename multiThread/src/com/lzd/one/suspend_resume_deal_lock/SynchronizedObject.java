package com.lzd.one.suspend_resume_deal_lock;
/**
 * suspend和resume方法的缺陷，如果只暂停锁，而不释放锁
 * 会造成公共的同步对象的独占
 * @date 2016年5月23日
 * @author lzd
 *
 */
public class SynchronizedObject {
	synchronized public void printString(){
		System.out.println("begin");
		if(Thread.currentThread().getName().equals("a")){
			System.out.println("a线程永远 suspend了，永远暂停了");
			Thread.currentThread().suspend();
		}
		System.out.println("end");
	}

}
