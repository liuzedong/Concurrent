package com.lzd.demoisdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试线程问题
 * @date 2016年9月8日
 * @author lzd
 *
 */
public class ThreadDemo {


	private static Map<String, String> map;
	
	
	static {
		map = new HashMap<String, String>();
		map.put("保单号1", "123456");
		map.put("保单号2", "123456");
		map.put("保单号3", "123456");
		map.put("保单号4", "123456");
		map.put("保单号5", "123456");
		map.put("保单号6", "123456");
		map.put("保单号7", "123456");
		map.put("保单号8", "123456");
		map.put("保单号9", "123456");
		map.put("保单号10", "123456");
		map.put("保单号11", "123456");
		map.put("保单号12", "123456");
		map.put("保单号13", "123456");
		map.put("保单号14", "123456");
		map.put("保单号15", "123456");
		map.put("保单号16", "123456");
	}
	
	
	public static void main(String[] args) {
		
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				map.get("保单号11");
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				map.get("保单号1");
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				map.get("保单号2");
			}
		});
		
	}
	
	
}
