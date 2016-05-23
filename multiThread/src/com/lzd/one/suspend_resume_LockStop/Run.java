package com.lzd.one.suspend_resume_LockStop;
/**
 * 错误使用suspend和resume方法的不良后果
 * @date 2016年5月23日
 * @author lzd
 *
 */
public class Run {
	
	public static void main(String[] args) {
		try{
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(1000);
			thread.suspend();
			System.out.println("main end");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}

}
