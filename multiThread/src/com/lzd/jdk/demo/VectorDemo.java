package com.lzd.jdk.demo;

import java.util.Enumeration;
import java.util.Stack;
import java.util.Vector;

import org.junit.Test;

/**
 * 测试Vector这个类的源码
 * @date 2016年6月23日
 * @author lzd
 *
 */
public class VectorDemo {

	@Test
	public void jdkVector(){
		Vector< String> v = new Vector<String>();
		v.add("刘德华1");
		v.add("刘德华2");
		v.add("刘德华3");
		for (int i = 0; i < 2000; i++) {
			v.add("刘德华" + i);
		}
		
		v.add(2, "张学友");
		
		v.addElement("曾志伟");
		
//		v.clear();
		v.clone();
		
		v.contains("张学友");
		
		v.elements();
		v.hashCode();
		String name = v.elementAt(2);
		
		v.isEmpty();
		v.lastElement();
		v.lastIndexOf("李连杰");
		
		v.remove(1);
		v.lastIndexOf("张学友",-19);
		
		v.remove("啊");
		
		Stack<String> s = new Stack<String>();
		s.empty();
		s.peek();
		
		
		System.out.println(name);
		System.out.println(v);
		System.out.println(v.capacity());
	}
	
	@Test
	public void myVector(){
//		MyVector<String> v = new MyVector<String>();
		MyStack<String> v = new MyStack<String>();
		v.add("刘德华1").add("刘德华2").add("刘德华3").add("刘东");
		
		v.add(1, "张学友");
		
		v.addElement("曾志伟1").addElement("曾志伟2");
		
		boolean contains = v.contains("刘东");
		
		Object[] copyArray = new Object[100];
		v.copyInfo(copyArray);
		String name = v.elementAt(2);
		
		// 获取这个对象的迭代对象，然后迭代出来所有的值
		Enumeration<String> elements = v.elements();
		while(elements.hasMoreElements()){
			System.out.print(elements.nextElement() + ",");
		}
		System.out.println();
		
		// 获得 这个集合的第一个元素
		String firstName = v.firstElement();
		boolean b = v.isEmpty();
		String lastName = v.lastElement();
		
		v.lastIndexOf("刘东", 6);
		v.remove(2).remove(2).remove(2);
		
		v.empty();
		
		
		String peekName = v.peek();
		// 出栈
		v.pop();
		
		
		System.out.println("栈顶的元素：" + peekName);
		System.out.println("这个集合是否为空的：" + b);
		System.out.println("集合的第一个数据：" + firstName);
		System.out.println("集合的最后一个数据：" + lastName);
		System.out.println("指定位置的值为：" + name);
		System.out.println("是否包含指定的元素：" + contains);
		System.out.println("有多少数据：" + v.size());
		System.out.println("当前容器的大小：" + v.capacity());
		
	}
	
}
