package com.lzd.jdk.demo;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

/**
 * 测试LinkedList集合的案例
 * @date 2016年6月21日
 * @author lzd
 *
 */
public class ListDemo2 {

	// JDK中的linkedList
	@Test
	public void jdkLinkedList(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("刘东1");
		list.add("刘东2");
		list.add("刘东3");
		list.add("刘东4");
		list.add("刘东5");
		list.add("刘东6");
		list.add("刘东7");
		list.addFirst("第一个");
		list.getFirst();
		list.getLast();
		
		list.add(2, "张学友");
		
		list.remove();
		
		
		// 向集合中添加第二个集合
		LinkedList<String> list2 = new LinkedList<String>();
		list2.add("我是第二个元素1");
		list2.add("我是第二个元素2");
		list.addAll(list2);
		
		list.get(1);
		
		
		
		System.out.println(list);
	}
	
	// 自己的linkedList
	@Test
	public void myLinkedList(){
		MyLinkedList<String> a = new MyLinkedList<String>();
		a.add("刘东").add("张学友").add("曾志伟1").add("曾志伟2").add("曾志伟3");
		// 获得第一个元素
		String firstStr = a.getFirst();
		
		// 获得最后一个元素
		String lastStr = a.getLast();
		
		// 在指定位置上面插入数据。
		a.add(2, "古天乐");
		
		// 自己定义的这个添加的是当前集合，不能添加其他集合
		MyLinkedList<String> a2 = new MyLinkedList<String>();
		a2.add("张三").add("李四").add("王五").add("赵六");
		a.addAll(a2);
		
		// 获取指定位置元素的值
		String indexStr = a.get(3);
		System.out.println("指定位置元素的值：" + indexStr);
		
		a.removeFirst();
		a.removeLast();
		
		// 以数组的形式显示集合中的内容
		Object[] strArray = a.toArray();
		System.out.println("返回的数组：" + Arrays.toString(strArray) + "，数组的长度：" + strArray.length);
		
		System.out.println("第一个元素：" + firstStr);
		System.out.println("最后一个元素：" + lastStr);
		System.out.println("这个集合中有多少个元素：" + a.size());
	}
}
