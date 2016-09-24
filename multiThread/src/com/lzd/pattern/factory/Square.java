package com.lzd.pattern.factory;
/**
 * 画一个正方形
 * @date 2016年9月14日
 * @author lzd
 *
 */
public class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("我就是来画一个正方形的");
	}

}
