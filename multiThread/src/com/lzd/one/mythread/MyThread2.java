package com.lzd.one.mythread;
/**
 * 创建一个线程，来测试线程运行的不确定性
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class MyThread2 extends Thread{

	@Override
	public void run() {
		try{
			for (int i = 0; i < 10; i++) {
				int time = (int) (Math.random() * 1000);
				Thread.sleep(time);
				System.out.println("run = " + Thread.currentThread().getName());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// 获得一个随机的数字
		System.out.println(Math.random() * 1000);
	}

}
