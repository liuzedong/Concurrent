package com.lzd.nosafe;
/**
 *售票台
 * @date 2016年7月10日
 * @author lzd
 */
public class Station {
	
	
	public static void main(String[] args) {
		// 一个售票的过程，四个售票台
		Tickets ticket = new Tickets();

		Thread station1 = new Thread(new Tickets());
		Thread station2 = new Thread(new Tickets());
		Thread station3 = new Thread(new Tickets());
		Thread station4 = new Thread(new Tickets());
		
		station1.start();
		station2.start();
		station3.start();
		station4.start();
		
	
	}

}
