package com.lzd.one.controller;
/**
 * 线程A进行登录
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class ALogin extends Thread{

	@Override
	public void run() {
		super.run();
		LoginServlet.doPost("a", "aa");
	}

}
