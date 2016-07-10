package com.lzd.mistake;
/**
 * 模拟妈妈叫儿子去买酱油和做菜的过程
 * @date 2016年7月10日
 * @author lzd
 */
public class Mother implements Runnable{

	// 妈妈做饭的过程
	@Override
	public void run() {
		System.out.println("妈妈准备做饭");
		
		System.out.println("妈妈发现酱油用完啦");
		
		System.out.println("妈妈叫儿子去买酱油");
		
		// 创建一个儿子线程，然后让儿子去买酱油
		Thread son = new Thread(new Son());
		son.start();
		
		
		System.out.println("妈妈等待儿子把酱油买回来");
		
		System.out.println("妈妈开始做饭");
		
		System.out.println("妈妈的饭做好啦");
		
		
		
	}

}
