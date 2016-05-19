package com.lzd.one.mythread;
/**
 * 在主线程中，使用interrupt()来告知线程需要停止，然后再调用的线程中，使用interrupted()来判断，是否需要停止
 * 如果需要停止，则不执行后面的语句
 * 但是，只是跳出运行语句，并没有 停止线程执行
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class MyThread9 extends Thread{

	
	@Override
	public void run() {
		long b = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i = " + (i+1));
			if(this.interrupted()){
				System.out.println("线程已经停止了");
				break;
			}
		}
		System.out.println(System.currentTimeMillis() -b );
	}

}
