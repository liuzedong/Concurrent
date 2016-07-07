package com.lzd.jdk.demo;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * 自己建立一个Vector来模拟JDK的Vector，并做写笔记记录
 * 创建的时候，默认的是10个数组的大小
 * 三个集合的区别，ArrayList,LinkedList,Vector
 * ArrayList：内部使用的数组，进行封装数据。里面有一个object[]和size来进行记录数据
 * LinkedList：内部使用的双链表，进行封装的数据。
 * 					里面有一个Node对象，里面有next(下一个对象)，prev(上一个对象)，item(当前数据)。
 * Vector：里面和ArrayList实现是一个样的，都是使用的数组来封装数据，不同之处在于，里面所有的方法都是同步的
 * 			  里面的方法都是使用的synchronized 进行同步的，有部分使用的同步代码块。
 * 			  里面有一个object[]和size来进行记录数据
 * Stack：它是继承Vector的，里面所有的方法也是同步的。只是它是模拟队的形式来进行数据的操作的。
 * 			里面的数据接口应该是LinkedList = Vector + Stack; ArrayList没有进行模拟栈的形式。
 * @date 2016年6月23日
 * @author lzd
 *
 */
public class MyVector<E> {
	
	// 用来装数据的
	private Object[] objects ;
	
	// 用来记录数组中元素的个数
	private int size;
	
	// 还有个自动扩容方法，我就不去实现勒
	
	public MyVector(int s){
		objects = new Object[s];
	}
	
	public MyVector(){
		this(10);
	}
	
	// 添加数据，这个数组中，用所有的方法，都是同步的
	public synchronized MyVector<E> add(E e){
		// 检查数组
		grow(size);
		
		// 向数组中添加元素
		objects[size++] = e;
		
		
		return this;
	}
	
	// 检查当前数组的大小和数组的长度，如果，长度不够啦，就信息扩容
	private void grow(int bigSize){
		if (bigSize >= objects.length){
			// 扩容，简单的方式，直接在原来的基础上+10,然后吧，原先的数据复制进去
			objects = Arrays.copyOf(objects, objects.length + 10);
			
		}
	}
	
	// 向指定位置插入值
	public MyVector<E> add(int index, E e){
		insertElementAt(e, index);
		return this;
	}
	
	// 向这个集合的尾部，进行添加数据
	public synchronized MyVector<E> addElement(E e){
		// 看看，插入的位置，会不会大于当前数组的长度，如果大于，那么就扩容
		grow(size + 1);
		
		objects[size++] = e;
		
		return this;
	}
	
	// 把对象插入指定的位置
	public synchronized MyVector<E> insertElementAt(E e, int index){
		if(index >= size){
			throw new ArrayIndexOutOfBoundsException("你插入的位置，超过当前的长度啦。。。");
		}
		
		// 如果插入的长度，正好是最后一个，那么，就进行扩容
		grow(size + 1);
		
		// 最后，就是在指定位置插入值，就是把数组，Copy然后，插入，把数组内容向后移动移位。
		System.arraycopy(objects, index, objects, index + 1, size - index);
		// 在指定位置插入值
		objects[index] = e;
		
		size++;
		
		return this;
	}
	
	
	// 返回当前数组的大小，就是容量的大小
	public synchronized int capacity(){
		return objects.length;
	}
	
	
	// 获取数组长度
	public synchronized int size(){
		return size;
	}
	
	// 移除全部的数据，JDK中移除勒所有的数据，但是里面的容量还在的。感觉不是特别的好
	public void clear(){
		removeAllElements();
	}
	
	//  移除全部的数据
	public synchronized void removeAllElements(){
		for(int i=0; i < size; i++)
			objects[i] = null;
		size = 0;
	}
	
	// 查看集合中，是否包含指定的元素。就是直接调用indexOf这个类
	public boolean contains(E e){
		return indexOf(e, 0) >= 0;
	}
	
	
	
	// 从该数组中的指定位置，开始收搜，第一次出现该元素的位置
	public synchronized int indexOf(Object e, int index){
		// 这个数组，是可以存入空值的，所以  null的对比和 实体类的对不是不一样的
		if(e == null){
			for (int i = index; i < size; i++) {
				if(objects[i] == null)
					return i;
			}
		}else{
			for (int i = index; i < size; i++) {
				if(e.equals(objects[i]))
					return i;
			}
		}
		return -1;
	}
	
	
	// 把数组复制到指定的数组当中
	public synchronized void copyInfo(Object[] array){
		System.arraycopy(objects, 0, array, 0, size);
	}
	
	
	// 返回指定位置的值，就是传说中的返回指定节点的值
	public synchronized E elementAt(int index){
		
		if(index > size && index < 0){
			throw new ArrayIndexOutOfBoundsException(index + " >= " + size  + ",就是说，你要的数据，不在指定的范围內");
		}
		
		return elementData(index);
	}
	
	// 返回这个 对象的组建值，就是传说中的迭代对象，迭代模式
	public Enumeration<E> elements(){
		return new Enumeration<E>() {
			
			// 定义一个变量，当取完一个值后，就返回就行加一
			int count = 0;
			
			
			// 是否下一个元素
			@Override
			public boolean hasMoreElements() {
				return size > count ;
			}

			// 取得下一个元素，使用对象锁，来获取，这样可以进行同步
			@Override
			public E nextElement() {
				synchronized(MyVector.class){
					if(size > count){
						return elementData(count++);
					}
				}
				
				// 如果没有这个值的话，那么我就抛个异常给你尝尝
				throw new NoSuchElementException("我这个对象，获取不到这个值，对不起啦，辣鸡");
			}
		};
	}
	
	
	// 获取到第一个该集合的第一个数据
	public synchronized E firstElement(){
		return elementData(0);
	}
	
	// 获得指定位置的数据
	public synchronized E get(int index){
		if(index > size && index < 0){
			throw new ArrayIndexOutOfBoundsException(index + " >= " + size  + ",就是说，你要的数据，不在指定的范围內");
		}
		return elementData(index);
	}
	
	// 返回指定对象，第一次出现的位置，就是传说中的索引，如果不存在，那么就返回-1啦
	public synchronized int indexOf(Object obj){
		if(obj == null){
			for (int i = 0; i < size; i++) {
				if(objects[i] == null)
					return i;
			}
		}else{
			for (int i = 0; i < size; i++) {
				if(obj.equals(objects[i]))
					return i;
			}
		}
		
		return -1;
	}
	
	// 检测这个元素是否是空的，是空的：true。非空的：flash
	public synchronized boolean isEmpty(){
		return size == 0;
	}
	
	
	// 返回这个集合的最后一个元素
	public synchronized E lastElement(){
		if(size == 0){
			throw new ArrayIndexOutOfBoundsException("你的集合是空的，没有这个元素");
		}
		//  这个地方记得，减一，因为 长度和数组的位置不同
		return elementData(size - 1);
		
	}
	
	// 从数组的尾部开始查找元素，  直接使用这个元素的size-1 就行勒，因为长度是使用的是自然人认识的数字。
	// 计算机的数字是从0开始的，自然人的数组是从1开始的
	public synchronized int lastIndexOf(Object o){
		return lastIndexOf(o, size -1);
	}
	
	
	// 查询，从集合后面的指定位置的位置，开始查找 这个元素，找到勒，就返回这个元素所在的位置
	public synchronized int lastIndexOf(Object o, int index){
		if(index <0 || index >= size){
			 throw new IndexOutOfBoundsException(index + " >= "+ size);
		}
		if (o == null) {
			for (int i = index; i >= 0; i--) {
				if (objects[i] == null){
					return i;
				}
			}
		}else{
			for (int i = index; i >= 0; i--) {
				if (o.equals(objects[i])){
					return i;
				}
			}
		}
		
		return -1;
	}
	
	
	// 移除指定位置的元素
	public synchronized MyVector<E> remove(int index){
		if(index <0 || index >= size){
			 throw new IndexOutOfBoundsException("你要移除的位置，不在该数组的范围內");
		}
		
		// 把移除位置，到后面的元素，全部向前移动一位，然后把最后一个元素进行置为null，计算你出需要移动的个数
		int mvoedNum = size - index - 1;
		if(mvoedNum > 0){
			// 这一步，把后面的元素，向前一个复制
			System.arraycopy(objects, index + 1, objects, index, mvoedNum);
		}
		// 把最后一个元素，置为null
		size--;
		objects[size] = null;
		
		return this;
	}
	
	
	// 移除从数组开头找到的第一个元素
	public synchronized MyVector<E> remove(Object o){
		int index = indexOf(o);
		remove(index);
		return this;
	}
	
	// 获得指定位置的元素
	@SuppressWarnings("unchecked")
	E elementData(int index){
		return (E) objects[index];
	}
	
}
