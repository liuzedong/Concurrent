package com.lzd.one.suspend_resume_test;
/**
 * 暂停线程示例
 * suspend与resume方法的使用
 * suspend()停止线程，resume()恢复线程
 * @date 2016年5月23日
 * @author lzd
 *
 */
public class MyThread extends Thread{

	private long i = 0;
	
	public long getI() {
		return i;
	}

	public void setI(long i) {
		this.i = i;
	}

	@Override
	public void run() {
		while(true){
			i++;
		}
	}

}
