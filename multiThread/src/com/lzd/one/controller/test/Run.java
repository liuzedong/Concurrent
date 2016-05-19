package com.lzd.one.controller.test;

import com.lzd.one.controller.ALogin;
import com.lzd.one.controller.BLogin;

/**
 * 进行这个A线程和B线程 进行登录的测试
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		ALogin a = new ALogin();
		a.start();
		BLogin b = new BLogin();
		b.start();
	}
}
