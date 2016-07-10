package com.lzd.noqueue;
/**
 * 水龙头，用来模拟接水的过程
 * @date 2016年7月10日
 * @author lzd
 */
public class Water {
	
	// 模拟接水的流程
	public void flowWater(){
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
