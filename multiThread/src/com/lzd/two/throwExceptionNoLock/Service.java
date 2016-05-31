package com.lzd.two.throwExceptionNoLock;
/**
 * 当一个线程执行的代码出现异常时，其所持有的锁会自动释放
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class Service {

	synchronized public void testMethod(){
		if(Thread.currentThread().getName().equals("a")){
			System.out.println("ThreadName = " + Thread.currentThread().getName() + 
					" run beginTime = " + System.currentTimeMillis());
			int i = 1;
			while(i == 1){
				if(("" + Math.random()).substring(0, 8).equals("0.123456")){
					System.out.println("ThreadName = " + Thread.currentThread().getName() +
							" run exception Time = " + System.currentTimeMillis());
					Integer.parseInt("a");
				}
			}
		}else{
			System.out.println("Thread B run Time = " + System.currentTimeMillis());
		}
	}
}
