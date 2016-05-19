package com.lzd.one.controller;
/**
 * 线程B进行登录
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class BLogin extends Thread{

	@Override
	public void run() {
		super.run();
		LoginServlet.doPost("b", "bb");
	}

}
