package com.lzd.two.synLockIn_2;
/**
 * 可重入锁   也支持在父子类继承的环境中
 * @date 2016年5月27日
 * @author lzd
 *
 */
public class Main {

	public int i = 10;
	
	synchronized public void operateMainMethod(){
		try {
			while(i > 0){
				i--;
				System.out.println("Main print i = " + i);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
