package com.lzd.one.suspend_resume_nosameValue;
/**
 * 
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) throws InterruptedException {
		final MyObject object = new MyObject();
		// 线程1进入线程，然后停止了线程
		Thread thread1 = new Thread(){
			public void run(){
				object.setValue("a", "aa");
			}
		};
		thread1.setName("a");
		thread1.start();
		Thread.sleep(500);
		
		// 线程2进入线程，但是因为线程1 停止了线程，所以线程2造成数据的不一致性
		Thread thread2 = new Thread(){
			public void run(){
				object.printUsernamePassword();
			}
		};
		thread2.start();
	}
}
