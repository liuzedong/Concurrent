package com.lzd.one.suspend_resume_deal_lock;
/**
 * 测试线程，永远被暂停的案例
 * @date 2016年5月23日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		try{
			final SynchronizedObject object = new SynchronizedObject();
			Thread thread1 = new Thread(){
				@Override
				public void run() {
					object.printString();
				}
			};
			thread1.setName("a");
			thread1.start();
			Thread.sleep(1000);
			
			Thread thread2 = new Thread(){
				@Override
				public void run() {
					System.out.println("thread2 启动了。但是进不去printString()方法，只能打印一个begin");
					System.out.println("因为printString方法被a线程锁定，并且永远suspend暂停了");
					object.printString();
				}
			};
			thread2.start();
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
