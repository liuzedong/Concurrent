package com.lzd.together;

/**
 * 水龙头，用来模拟接水的过程
 * 
 * @date 2016年7月10日
 * @author lzd
 */
public class Water {

	// 定义一个变量，来记录学生数
	private int studentNumber = 0;

	// 模拟接水的流程
	public synchronized void flowWater() {
		// 使用对象，进行枷锁，然后，接水完成侯，然其他线程处于等待状态，等所有学生
		// 接完水后，在进行唤醒其他接水的同学
		synchronized (this) {

			System.out.println("开始进行接水");

			studentNumber++;

			try {
				// 接水的停顿时间
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("结束接水");

			// 如果少于4个同学，那么就等待，超过四个同学后，就唤醒其他学生，让他们一起回家
			if (studentNumber < 4) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			} else {
				// 叫醒其他线程
				notifyAll();
			}
		}
	}

}
