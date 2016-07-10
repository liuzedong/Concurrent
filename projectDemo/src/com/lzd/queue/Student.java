package com.lzd.queue;
/**
 * 学生类，
 * @date 2016年7月10日
 * @author lzd
 */
public class Student extends Thread{
	
	
	// 姓名
	private String name;
	
	// 水龙头，用来接水
	private Water water;

	public Student(String name, Water water) {
		super();
		this.name = name;
		this.water = water;
	}
	
	// 学生接水
	public void receiveWater(){
		System.out.println(name + "正在跑向接水机器");
		water.flowWater();
		System.out.println(name + "正在返回教室");
	}

	// 调用此方法进行实际的学生接水动作
	@Override
	public void run() {
		receiveWater();
	}

	
	
}
