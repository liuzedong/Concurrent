package com.lzd.pattern.abstractFactory;
/**
 * 画一个正方形
 * @date 2016年9月18日
 * @author lzd
 *
 */
public class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("我就是用来画一个正方形的");
	}

}
