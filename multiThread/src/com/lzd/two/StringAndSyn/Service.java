package com.lzd.two.StringAndSyn;
/**
 * 将synchronized(string) 同步代码块与String联合使用
 * 使用到Sring的常量池
 * @date 2016年6月2日
 * @author lzd
 *
 */
public class Service {
	public static void print(String stringParam){
		try {
			synchronized(stringParam){
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
