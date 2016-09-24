package com.lzd.pattern.abstractFactory;
/**
 * 抽象工厂的使用类
 * @date 2016年9月18日
 * @author lzd
 *
 */
public class AbstractFactoryPatternDemo {

	
	public static void main(String[] args) {
		// 获取形状的工厂
		AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
		
		// 获取形状的Circle形状
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		
		// 获取形状Square
		Shape shape2 = shapeFactory.getShape("SQUARE");
		shape2.draw();
		
		// 获取形状Rectangle
		Shape shape3 = shapeFactory.getShape("RECTANGLE");
		shape3.draw();
		
		
		System.out.println();
		
		
		// 获取颜色的工厂
		AbstractFactory colorFactory = FactoryProducer.getFactory("color");
		
		// 获取红色
		Color color1 = colorFactory.getColor("RED");
		color1.fill();
		
		// 获取蓝色
		Color color2 = colorFactory.getColor("BLUE");
		color2.fill();
		
		// 获取绿色
		Color color3 = colorFactory.getColor("GREEN");
		color3.fill();
	}
	
}
