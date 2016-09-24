package com.lzd.pattern.singleton;
/**
 * 单例设计模式，这就是一个单例的实例，不能直接创建
 * 这个单例设计模式，就是传统的饿汉式
 * @date 2016年9月19日
 * @author lzd
 *
 */
public class SingleObject {

	// 创建SingleObject 的一个对象
	private static SingleObject instance = new SingleObject();
	
	// 让构造方法为private，这样该类就不能被实例化啦
	private SingleObject(){}
	
	// 获取唯一可用的对象
	public static SingleObject getInstance(){
		return instance;
	}
	
	/**
	 * 这个单例类中，所需要处理的逻辑
	 * 
	 * @author 刘泽栋 2016年9月19日 下午3:49:05
	 */
	public void showMessage(){
		System.out.println("Hello World");
	}
	
}
