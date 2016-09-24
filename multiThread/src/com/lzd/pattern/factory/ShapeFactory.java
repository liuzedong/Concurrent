package com.lzd.pattern.factory;
/**
 * 一个画的工厂类，这个类来实例化所有接口的实现类
 * @date 2016年9月14日
 * @author lzd
 *
 */
public class ShapeFactory {

	
	public Shape getShape(String shapeType){
		if (shapeType == null){
			return null;
		}
		switch(shapeType) {
			case"CIRCLE" : return new Circle();
			case "RECTANGLE" : return new Rectangle();
			case "SQUARE" : return new Square();
			default : return null;
		}
	}
	
}
