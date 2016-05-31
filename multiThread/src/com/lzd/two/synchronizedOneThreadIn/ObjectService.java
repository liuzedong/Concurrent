package com.lzd.two.synchronizedOneThreadIn;
/**
 * 同步代码块的使用synchronized(this)
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class ObjectService {

	public void serviceMethod(){
		try {
			synchronized(this){
				System.out.println("begin time = " + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("end time = " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
