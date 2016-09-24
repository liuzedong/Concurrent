package com.lzd.pattern.abstractFactory;
/**
 * 一个抽象工厂，用来获取具体的接口
 * @date 2016年9月18日
 * @author lzd
 *
 */
public abstract class AbstractFactory {

	abstract Color getColor(String color);
	abstract Shape getShape(String shape);
	
}
