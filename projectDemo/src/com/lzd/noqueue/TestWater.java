package com.lzd.noqueue;
/**
 * 测试四个学生不排队进行接水
 * @date 2016年7月10日
 * @author lzd
 */
public class TestWater {
	
	
	public static void main(String[] args) {
		// 创建四个学生，和一个水龙头
		Water water = new Water();
		Student xiaoliu = new Student("小刘", water);
		Student xiaoming = new Student("小明", water);
		Student xiaoyue = new Student("小月", water);
		Student xiaoxiao = new Student("小小", water);
		
		// 小刘-小月-小明-小小。  这四个人是这样的顺序去接水，但是却不一定是小刘先打完
		xiaoliu.start();
		xiaoyue.start();
		xiaoming.start();
		xiaoxiao.start();
		
	}

}
