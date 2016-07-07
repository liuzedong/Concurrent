package com.lzd.jdk.demo;

import java.util.HashMap;

import org.junit.Test;

/**
 * 模拟HashMap的源码的案例
 * @date 2016年6月24日
 * @author lzd
 *
 */
public class HashMapDemo {

	
	@Test
	public void jdkHashMap(){
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("姓名", "刘东");
		map.put("姓名1", "刘东");
		for (int i = 4; i < 120; i++) {
			map.put("姓名" + i, "刘东");
		}
		
	}
	
	
	@Test
	public void myHashMap(){
		
	}
	
}
