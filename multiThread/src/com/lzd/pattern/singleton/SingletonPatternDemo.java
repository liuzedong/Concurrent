package com.lzd.pattern.singleton;
/**
 * 使用单例对象的测试类
 * @date 2016年9月19日
 * @author lzd
 *
 */
public class SingletonPatternDemo {
	
	public static void main(String[] args) {
		// 获取对象的唯一实例
		SingleObject singleObject = SingleObject.getInstance();
		
		// 显示消息
		singleObject.showMessage();
	}

}
