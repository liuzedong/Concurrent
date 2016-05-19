package com.lzd.one.test;

import com.lzd.one.mythread.CountOperate;

/**
 * 运行CountOperate类，查看 打印出来的 名称
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class Run_CountOperate {
	
	public static void main(String[] args) {
		CountOperate c = new CountOperate();
		Thread t = new Thread(c);
		t.setName("A");
		t.start();
		/*c.setName("A");
		c.start();*/
	}

}
