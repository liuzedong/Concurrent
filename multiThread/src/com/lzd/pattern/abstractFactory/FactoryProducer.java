package com.lzd.pattern.abstractFactory;
/**
 * 工厂创造器，用来创建工厂所使用的
 * @date 2016年9月18日
 * @author lzd
 *
 */
public class FactoryProducer {

	public static AbstractFactory getFactory(String choice){
		if (choice.equalsIgnoreCase("SHAPE")){
			return new ShapeFactory();
		} else if (choice.equalsIgnoreCase("COLOR")){
			return new ColorFactory();
		}
		return null;
	}
	
	
}
