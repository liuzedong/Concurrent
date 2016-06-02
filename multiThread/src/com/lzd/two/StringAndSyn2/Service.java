package com.lzd.two.StringAndSyn2;
/**
 * 最好不要使用String来进行加锁，使用对象来进行加锁，那么就不会持有的同一把锁
 * 使用到Sring的常量池
 * @date 2016年6月2日
 * @author lzd
 *
 */
public class Service {
	public static void print(Object object){
		try {
			synchronized(object){
				while(true){
					System.out.println("当先线程的名称：" + Thread.currentThread().getName());
					Thread.sleep(5000);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
