package com.lzd.pattern.abstractFactory;
/**
 * 画一个圆形
 * @date 2016年9月18日
 * @author lzd
 *
 */
public class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("我就是用来画一个圆形的");
	}

}
