package com.lzd.jdk.demo;
/**
 * 这个是继承的Vector对象，Vector对象里面的方法都是可以使用的
 * 
 * @date 2016年6月24日
 * @author lzd
 *
 */
public class MyStack<E> extends MyVector<E>{
	
	
	// 查看这个集合是否是空的，直接使用父类的 size()方法
	public synchronized boolean empty(){
		return size() == 0;
	}
	
	
	// 返回栈顶的元素，其实就是 数组中的最后一个元素，获取到这个元素，但是不删除这个元素
	// objects和size这两个，字段在MyVector对象中是private，所以使用方法来调用
	public synchronized E peek(){
		return lastElement();
	}

	// 返回栈顶元素，并且移除这个元素，就是出栈。
	// 其实就是删除最后一个元素，并且返回他
	public synchronized E pop(){
		// 获得最后一个元素
		E lastE = lastElement();
		
		// 删除最后一个元素
		remove(size() - 1);
		return lastE;
	}
	
	// 入栈，就是向数组的最后面添加数据。直接调用父类中的方法
	public synchronized MyStack<E> push(E e){
		addElement(e);
		return this;
	}
	
	
	// 查找这个数据在数组中的位置。直接调用父类的方法就可以啦
	// 返回的是从数组后面开始数的位置，因为栈顶。是从后面开始的
	public synchronized int search(Object o){
		int index = indexOf(o);
		if(index > 0){
			return size() - index;
		}
		
		return -1;
	}
	
}
