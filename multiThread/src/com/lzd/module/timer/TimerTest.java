package com.lzd.module.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时任务的使用，这个类就是指定，定时任务所需要执行的类
 * @date 2016年7月19日
 * @author lzd
 *
 */
public class TimerTest extends TimerTask{

	// 创建成员变量
	// 创建一个字符串变量
	String index;
	// 创建一个Timer对象
	Timer myTimer = new Timer();
	
	
	// 创建一个构造函数
	
	public TimerTest(String index) {
		this.index = index;
	}
	
	
	// 编写一直执行的方法
	@Override
	public void run() {
		System.out.println(index);
	}

	
	
	// 实现反复执行的功能
	public void start(int delay, int internal){
		// 在delay*1000 时间后开始执行TimerTest对象，执行后每隔internal*1000返回执行
		
		myTimer.schedule(this, delay * 1000, internal * 1000);
	}
	
	// 调用该方法进行结束
	public void end(){
		myTimer.cancel();
	}
	
	
	// 主方法，进行调用
	public static void main(String[] args) {
		// 创建MyTask1 对象
		TimerTest myTask1 = new TimerTest("线程1执行");
		myTask1.start(0, 3);
		
		// 创建和设置myTask2 对象
		TimerTest myTask2 = new TimerTest("线程2执行");
		myTask2.start(0, 1);
		
		// 使线程休眠6秒
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 然后结束线程
		myTask1.end();
		myTask2.end();
		
		
		
		
	}
	
}
