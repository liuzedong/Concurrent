package com.lzd.normal;
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

		// 在妈妈等待儿子进行买酱油的时候，下面的代码是不能运行的
		try {
			son.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("发生异常");
			System.out.println("妈妈终止做饭");
			System.exit(1);			// 推出系统
		}
		
		
		System.out.println("妈妈开始做饭");
		
		System.out.println("妈妈的饭做好啦");
		
		
		
	}

}
