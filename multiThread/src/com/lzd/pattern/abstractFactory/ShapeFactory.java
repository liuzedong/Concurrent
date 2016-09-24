package com.lzd.pattern.abstractFactory;
/**
 * 扩展AbstractFactory 抽象工厂类，生成实体
 * @date 2016年9月18日
 * @author lzd
 *
 */
public class ShapeFactory extends AbstractFactory{

	@Override
	Color getColor(String color) {
		return null;
	}

	@Override
	Shape getShape(String shape) {
		if (shape == null){
			return null;
		}
		
		switch (shape){
			case "CIRCLE" :
				return new Circle();
			case "SQUARE" :
				return new Square();
			case "RECTANGLE" :
				return new Rectangle();
			default :
				return null;
		}
	}
}
