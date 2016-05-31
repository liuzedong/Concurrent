package com.lzd.two.synchronizedbad;
/**
 * 运行 其中一个线程，运行时间过长，然后另外一个线程，只有等待，上一个线程执行完成，才能继续运行
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class Run {
	
	public static void main(String[] args) {
		Task task = new Task();
		MyThread1 thread1 = new MyThread1(task);
		thread1.start();
		MyThread2 thread2 = new MyThread2(task);
		thread2.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long beginTime = CommonUtils.beginTime1;
		if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
			beginTime = CommonUtils.beginTime2;
		}
		long endTime = CommonUtils.endTime1;
		if (CommonUtils.endTime1 > CommonUtils.endTime2) {
			endTime = CommonUtils.endTime2;
		}
		
		System.out.println("总共耗时：" + ((endTime - beginTime)/1000));
	}

}
