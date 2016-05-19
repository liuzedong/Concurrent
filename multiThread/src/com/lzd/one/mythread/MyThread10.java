package com.lzd.one.mythread;
/**
 * 使用异常和interrupted()方法  结合，来使  线程停止
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class MyThread10 extends Thread{

	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if(this.interrupted()){
					System.out.println("已经是停止状态了，我要退出");
					throw new InterruptedException();
				}
				System.out.println("i = "+ (i+1));
			}
			System.out.println("我在for的下面，看看，会不会运行到我身上");
		} catch (InterruptedException e) {
			System.out.println("这里 抛出异常了");
			e.printStackTrace();
		}
		
	}

}
