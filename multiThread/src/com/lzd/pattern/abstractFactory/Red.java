package com.lzd.pattern.abstractFactory;
/**
 * 红色
 * @date 2016年9月18日
 * @author lzd
 *
 */
public class Red implements Color{

	@Override
	public void fill() {
		System.out.println("用红色填满啦");
	}

}
