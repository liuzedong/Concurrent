package com.lzd.jdk.demo;

import java.util.NoSuchElementException;

/**
 * 自己创建一个linkedList来模拟，真实的linkedList
 * @date 2016年6月21日
 * @author lzd
 *
 */
public class MyLinkedList<E> {

	// 定义最开始的一个元素
	private Node<E> first;
	
	// 定义最后的一个元素
	private Node<E> last;
	
	// 当前集合中存入勒多少个元素
	private int size;
	
	
	// 添加元素，可以链式添加
	public MyLinkedList<E> add(E e){
		addLast(e);
		return this;
	}
	
	// 向指定位置插入值
	public MyLinkedList<E> add(int index, E e){
		// 如果，需要保存的位置，超入范围，那么就会报错
		if(index <= 0 && index > size ){
			throw new NoSuchElementException("你的集合中没有元素");
		}
		
		// 如果，你要插入的位置是最后一个，那么就直接向最后面插入
		if(index == size){
			addLast(e);
		}else{
			
			// 获取插入位置上面的数据
			Node<E> x = first;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			
			// 获得这个元素的上一个元素
			Node<E> prev = x.prev;
			
			// 创建这个新的元素，然后这个元素的上下节点位置分别只想他们
			Node<E> newNode = new Node<E>(x, prev, e);
			
			// 修改上下节点的位置
			prev.next = newNode;
			x.prev = newNode;
			
			size++;
		}
		return this;
	}
	
	// 向这个集合中，添加一个集合。原理，获取到那个元素中的个数，然后，一个一个的添加到当前链表的后面
	public  MyLinkedList<E> addAll(MyLinkedList<E> c){
		
		// 把最后一个元素的下一个元素指向，新添加的元素
		last.next = c.first;
		c.first.prev = last;
		last = c.last;
		size += c.size();
		
		return this;
	}
	
	
	// 获得指定位置的元素
	public E get(int index){
		// 如果，需要查询的位置，超入范围，那么就会报错
		if(index <= 0 && index > size ){
			throw new NoSuchElementException("你查询的位置超出勒，这个元素的位置");
		}
		
		// 查询出这个元素
		Node<E> x = first;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		
		return  x.item;
	}
	
	// 返回第一个元素
	public E getFirst(){
		if(first == null){
			throw new NoSuchElementException("你的集合中没有元素");
		}
		return first.item;
	}
	
	// 返回最后一个元素
	public E getLast(){
		if(last == null){
			throw new NoSuchElementException("你的集合中没有元素");
		}
		return last.item;
	}
	
	
	// 把元素插入到最后面的一个元素
	public void addLast(E e){
		// 获取到最后的一个元素
		Node<E> l = last;
		// 创建一个元素，把存储的数据进入进去，创建一个新的Node
		final Node<E> newNode = new Node<E>(null, l, e);
		// 然后将这个节点，加入到最后的元素上面，因为是新加入的，所以放置的在最后面
		last = newNode;
		
		// 向最后一个元素中插入数据
		if (l == null){ // 说明，这就是最后一个对象
			first = newNode;
		}else{// 不然的话，就插入到下一个元素的尾部
			l.next = newNode;
		}
		
		// 最后将，这个集合的长度加一
		size ++;
		
		
	}
	
	
	public int size(){
		return size;
	}
	
	// 把集合转换称数组
	public Object[] toArray(){
		Object[] objects = new Object[size];
		
		int index = 0;
		// 遍历所有元素，然后放入到数组中
		for (Node<E> x = first; x != null; x= x.next) {
			objects[index++] = x.item;
		}
		
		return objects;
	}
	
	
	// 删除第一个元素
	public MyLinkedList<E> removeFirst(){
		
		if (first == null)
            throw new NoSuchElementException("你的数组中，没有数据");
		
		// 先获得first的下一个元素，将他，设置为第一个元素
		Node<E> nextNode = first.next;
		
		// 这种设置，有助与GC回收的
		first.item = null;
		first.next = null;
		
		// 将下一个元素，设置为第一个元素，然后这个第一个元素，的上一个元素，是空的
		first = nextNode;
		first.prev = null;
		
		// 删除后，记得把这个集合的长度减一
		size --;
		
		return this;
	}
	
	// 删除最后一个元素
	public MyLinkedList<E> removeLast(){
		if (last == null)
            throw new NoSuchElementException("你最后一个数据，为空");
		
		// 获得最后一个数据的，上一个数据，将连接位置，指向它
		Node<E> prevNode = last.prev;
		// 这种设置，有助与GC回收的
		last.item = null;
		last.prev = null;
		
		// 将倒数第二个节点设置为最后一个节点。并且删除掉
		last = prevNode;
		last.next = null;
		
		size --;
		return this;
	}
	
	// 需要一个 内部节点，来确定上一个元素，或者下一个元素
	private static class Node<E>{
		// 下一个元素
		private Node<E> next;
		// 上一个元素
		private Node<E> prev;
		// 当前元素，需要存储的数据
		private E item;
		
		public Node(Node<E> next, Node<E> prev, E item) {
			this.next = next;
			this.prev = prev;
			this.item = item;
		}
		
		
	}
	
}
