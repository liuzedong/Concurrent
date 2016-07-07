package com.lzd.jdk.demo;

import java.util.Objects;

/**
 * 模拟JDK的HashMap
 * 初始的大小为1<<4=16。这个对象对大不能超过1<<30=1073741824
 * 
 * 
 * @date 2016年6月24日
 * @author lzd
 *
 */
public class MyHashMap<K, V> {

	// 创建一个保存对象的数组
	static final Entry<?, ?>[] EMPTY_TABLE = {};
	
	// 转换上面的数组。用来保存数据的
	 @SuppressWarnings("unchecked")
	transient Entry<K,V>[] table = (Entry<K,V>[]) EMPTY_TABLE;
	
	
	
	
	// 在HashMap中，使用的一个对象来记录数据的，单链表
	static class Entry<K, V> {
		// 保存当先对象的key
		K key;
		// 保存当前对象的value
		V value;
		// 保存下一个对象
		Entry<K, V> next;
		// 保存这个hash值
		int hash;
		
		
		// 通过构造方法，获取到上面的值
		public Entry(K key, V value, Entry<K, V> next, int hash) {
			this.key = key;
			this.value = value;
			this.next = next;
			this.hash = hash;
		}
		
		
		// 获取当前key
		public final K getKey(){
			return key;
		}
		
		// 获取当前value 
		public final V getValue(){
			return value;
		}
		
		// 设置当前的value，并且返回上一个value
		public final V setValue(V newValue){
			V oldValue = value;
			value = newValue;
			return oldValue;
		}
		
		// 自定义当前对象的对比
		public boolean equals(Object o){
			// 如果不是当前对象，那么就直接返回false
			if(!(o instanceof Entry)){
				return false;
			}
			@SuppressWarnings("unchecked")
			Entry<K, V> e = (Entry<K, V>) o;
			// 获得当前对象的key和对比对象的k
			K k1 = getKey();	// 当前key
			K k2 = e.getKey();	// 对比的key
			
			// 对比完key，再就是对比value
			if(k1 == k2 || (k1 != null && k1.equals(k2))){
				V v1 = getValue();	// 当前的值
				V v2 = e.getValue();	// 需要对比的值
				if(v1 == v2 || (v1 != null && v1.equals(v2))){
					return true;
				}
			}
			
			return false;
		}
		
		// 这个HashCode直接使用Object的就行啦，其实我也不是很清楚，直接copy过来的
		public final int hashCode() {
            return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
        }

		// 打印toString的方法
		@Override
		public String toString() {
			return getKey() + "=" + getValue();
		}
	}
	
}
