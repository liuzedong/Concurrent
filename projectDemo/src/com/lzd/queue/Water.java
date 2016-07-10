package com.lzd.queue;
/**
 * 水龙头，用来模拟接水的过程
 * @date 2016年7月10日
 * @author lzd
 */
public class Water {
	
	// 模拟接水的流程,添加 synchronized关键字，进行枷锁
	public synchronized void flowWater(){
		System.out.println("开始进行接水");

		try {
			// 接水的停顿时间
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("结束接水");
	}

}
