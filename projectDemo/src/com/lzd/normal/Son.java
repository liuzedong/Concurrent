package com.lzd.normal;
/**
 * 儿子对象
 * @date 2016年7月10日
 * @author lzd
 */
public class Son implements Runnable{

	// 儿子去买酱油的过程
	@Override
	public void run() {
		System.out.println("儿子出门去买酱油");
		
		
		System.out.println("儿子买酱油需要花费5分钟的时间");
		
		for(int i =1; i<= 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("儿子发生意外");
			}
			System.out.println(i +"分钟");
		}
		
		
		System.out.println("儿子买酱油回来啦");
	}

}
