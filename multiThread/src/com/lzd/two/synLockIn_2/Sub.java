package com.lzd.two.synLockIn_2;
/**
 * 继承Main类
 * @date 2016年5月27日
 * @author lzd
 *
 */
public class Sub extends Main{

	synchronized public void operateSubMethod() {
		try{
			i--;
			System.out.println("sub print i = " + i);
			Thread.sleep(100);
			this.operateMainMethod();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
