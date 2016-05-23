package com.lzd.one.useReturnInterrupt;
/**
 * 使用interrupt()方法和return结合停止线程的案例
 * @date 2016年5月23日
 * @author lzd
 *
 */
public class MyThread extends Thread{

	@Override
	public void run() {
		while(true){
			if(this.interrupted()){
				System.out.println("线程停止了");
				return;
			}
			System.out.println("timer = " + System.currentTimeMillis());
		}
	}

}
