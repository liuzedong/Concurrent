package com.lzd.jdk.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 查看list中的源码
 * @date 2016年6月20日
 * @author lzd
 *
 */
public class ListDemo {
	
	@Test
	public void add(){
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list2.add("曾志伟");
		
		
		list.add("刘德华");
		list.add("刘德华");
		list.add("古天乐");
		list.add("刘德华");
		list.add("刘德华");
		list.add("刘德华");
		
		list.add(3, "刘东");
		
		for (int i = 0; i < 24; i++) {
			list.add("刘东" + i);
		}
		
		list.get(2);
		
		list.addAll(list2);
		
		list.contains("刘东");
		
		list.remove(2);
		
		
		list.clear();
		
		System.out.println(list);
	}
	
	@Test
	public void add2(){
		ArrayListDemo<String> a = new ArrayListDemo<String>();
		for (int i = 0; i < 24; i++) {
			a.add("刘东" + i);
		}
		
		// 向指定的位置插入数据
		a.add(1, "张学友");
		
		// 添加一个数组
		ArrayListDemo<String> a2 = new ArrayListDemo<String>();
		a2.add("曾志伟");
		a2.add("刘邦");
		
		a.addAll(a2);
		
		// 获得指定元素的位置
		int indexOf = a.indexOf("曾志伟");
		System.out.println(indexOf);
		
		// 查看是否包含某个元素
		boolean b = a.contains("刘东1");
		System.out.println(b);
		
		String s = a.remove(3);
		System.out.println(s);
		
//		a.clear();
		System.out.println(a);
		System.out.println(a.size());
	}

	@Test
	public void copy(){
		Object[] a = new Object[]{"刘东1", "刘东2", "刘东3", "刘东4", "刘东5", "刘东6"};
		
		a = Arrays.copyOfRange(a, 0, a.length + 10);
		System.out.println(Arrays.toString(a));
		
		
		
	}
	
	
}
