package com.lzd.two.innserTest2;
/**
 * 同步代码块synchronized(class2)对class2上锁后，其他线程只能以同步的方式
 * 调用class2中的静态同步方法
 * @date 2016年6月11日
 * @author lzd
 *
 */
public class OutClass {

	static class InnserClass1 {
		public void method1 (InnserClass2 class2){
			String threadName = Thread.currentThread().getName();
			synchronized(class2){
				System.out.println(threadName + " 进入InnserClass1类中的method1方法");
				for (int i = 0; i < 10; i++) {
					System.out.println("i = " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(threadName + " 离开InnserClass1类中的method1方法");
			}
		}
		
		public synchronized void method2 (){
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " 进入InnserClass1类中的method2方法");
			for (int j = 0; j < 10; j++) {
				System.out.println("j = " + j);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName + " 离开InnserClass1类中的method2方法");
		}
	}
	
	static class InnserClass2{
		public synchronized void method1(){
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " 进入InnserClass2类中的method1方法");
			for (int k = 0; k < 10; k++) {
				System.out.println("k = " + k);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName + " 离开InnserClass2类中的method1方法");
		}
	}
	
}

