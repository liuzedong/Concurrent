package com.lzd.two.innserTest1;
/**
 * 内置类中有两个同步的方法，但使用的却是不同的锁，打印的结果也是异步的
 * @date 2016年6月11日
 * @author lzd
 *
 */
public class OutClass {

	static class Inner {
		// 块锁
		public void method1(){
			synchronized("其他的锁"){
				for (int i = 0; i <= 10; i++) {
					System.out.println(Thread.currentThread().getName() + " i = " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		// 方法锁
		public synchronized void method2(){
			for (int i = 0; i <= 20; i++) {
				System.out.println(Thread.currentThread().getName() + " i = " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
