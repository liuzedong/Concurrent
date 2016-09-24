package com.lzd.pattern.abstractFactory;
/**
 * 绿色
 * @date 2016年9月18日
 * @author lzd
 *
 */
public class Green implements Color{

	@Override
	public void fill() {
		System.out.println("我用绿色填满勒");
	}

}
