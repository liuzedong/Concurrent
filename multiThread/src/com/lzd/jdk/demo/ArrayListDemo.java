package com.lzd.jdk.demo;

import java.util.Arrays;

public class ArrayListDemo<E> {

	private Object[] objects = new Object[10];

	private int size;

	// 向集合中添加数据
	public void add(E e) {
		objects[size++] = e;
		if (size == objects.length) {
			objects = Arrays.copyOf(objects, objects.length + 10);
		}
	}

	// 返回存入值的长度
	public int size() {
		return size;
	}

	// 打印
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		
		if(size == 0){
			return "[]";
		}
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i = 0; i < size; i++) {
			E e = (E) objects[i];
			s.append(e).append(",");
		}
		s.delete(s.length()-1, s.length());
		s.append("]");
		return s.toString();
	}

	// 获取指定位置上的数据
	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (i > size) {
			throw new IndexOutOfBoundsException();
		}
		return (E) objects[i];
	}

	// 向指定位置插入数据
	public void add(int index, E e){
		// 先判断，这个需要插入的位置，是不是  超出勒，下标的位置
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		// 把原有的数组中的元素，需要插入的数据，向后移动一个位置
		System.arraycopy(objects, index, objects, index + 1, size - index);
		objects[index] = e;
		size ++;
	}
	
	// 清空数组中的内容
	public void clear(){
		for (int i = 0; i < size; i++) {
			objects[i] = null;
		}
		size = 0;
	}
	
	// 用来获取数组
	public Object[] toArray(){
		return Arrays.copyOf(objects, size);
	}
	
	
	// 添加添加一个集合，这个是一个简陋的集合，不是所谓的集合接口，不是很兼容
	public void addAll(ArrayListDemo<E> a){
		Object[] os = a.toArray();
		int num = os.length;
		// 判断下，两个数组相加的长度，是不是 足够啦，不然的话，就需要扩容啦
		int newNum = num + objects.length;
		// 直接，把需要的长度，给扩容上去
		objects = Arrays.copyOf(objects, newNum);
		// 然后把需要的数组，进行复制进去
		System.arraycopy(os, 0, objects, size, num);
		
		// 然后给长度，进行相加，这样，就是现在的长度啦
		size += num;
		
	}
	
	// 获取元素在集合中所在的位置
	public int indexOf(Object o){
		if(o == null){
			for (int i = 0; i < size; i++) {
				if (objects[i] == null){
					return i;
				}
			}
		}else {
			for (int i = 0; i < size; i++) {
				if(o.equals(objects[i])){
					return i;
				}
			}
		}
		return -1;
	}
	
	// 查看集合中是否包含某个元素
	public boolean contains(Object o){
		return indexOf(o) >= 0;
	}
	
	// 删除指定位置上的元素，并且返回删除的元素
	public E remove(int i){
		// 先判断需要删除的位置是否大于当前所拥有的元素个数
		if(i > size){
			throw new IndexOutOfBoundsException();
		}
		
		@SuppressWarnings("unchecked")
		E oldObject = (E)objects[i];
		int numMove = size - i - 1;	// 需要移动的位数
		if(numMove > 0){
			System.arraycopy(objects, i + 1, objects, i, numMove);
		}
		// 把最后一个元素，置为null，并且把size的值减少一个
		objects[--size] = null;
		
		
		return oldObject;
	}
	
	
	
}
