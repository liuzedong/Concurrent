package com.lzd.mistake;
/**
 * 测试类，来模拟妈妈做饭的场景
 * @date 2016年7月10日
 * @author lzd
 */
public class Cooking {
	
	
	public static void main(String[] args) {
		Thread mother = new Thread(new Mother());
		mother.start();
	}

}
