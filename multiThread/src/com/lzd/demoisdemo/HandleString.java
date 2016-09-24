package com.lzd.demoisdemo;

import org.junit.Test;

/**
 * 处理String 字符串的方法
 * @date 2016年9月20日
 * @author lzd
 *
 */
public class HandleString {

	
	/**
	 * String 的的char[] 创建构造函数，指定范围
	 * 
	 * @author 刘泽栋 2016年9月20日 上午10:22:06
	 */
	@Test
	public void constructor1(){
		char[] a = {'a', 'b', 'c', 'd', 'e', 'f'};
		String str = new String(a, 2, 2);
		System.out.println("char array constructor result : " + str);
	}
	
}
