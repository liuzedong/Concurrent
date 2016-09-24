package com.lzd.pattern.abstractFactory;
/**
 * 颜色的工厂类
 * @date 2016年9月18日
 * @author lzd
 *
 */
public class ColorFactory extends AbstractFactory{

	@Override
	Color getColor(String color) {
		if (color == null){
			return null;
		}
		switch (color){
		case"RED" :
			return new Red();
		case "BLUE" :
			return new Blue();
		case "GREEN" :
			return new Green();
		default : 
			return null;
		}
	}

	@Override
	Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

}
