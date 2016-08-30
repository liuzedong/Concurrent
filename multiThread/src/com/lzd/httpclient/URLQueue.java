package com.lzd.httpclient;

import java.util.LinkedList;

/**
 * URL队列，保存将要访问的URL
 * @date 2016年8月29日
 * @author lzd
 *
 */
public class URLQueue {
	
	// 使用链表实现队列
	@SuppressWarnings("rawtypes")
	private LinkedList queue = new LinkedList();
	
	// 入队列
	@SuppressWarnings("unchecked")
	public void enQueue(Object t){
		queue.add(t);
	}

	// 出队列
	public Object deQueue(){
		return queue.removeFirst();
	}
	
	// 判断队列是否是空的
	public boolean isQueueEmpty(){
		return queue.isEmpty();
	}
	
	// 判断队列是否包含t
	public boolean contains(Object t){
		return queue.contains(t);
	}
	
	
}
