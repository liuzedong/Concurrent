package com.lzd.two.synNotExtends;
/**
 * 同步不可以继承，案例
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class Main {

	synchronized public void serviceMethod(){
		try {
			System.out.println("int main 下一步 sleep begin threadName = " + Thread.currentThread().getName()
					+ " time = " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int main 下一步 sleep end threadName = " + Thread.currentThread().getName()
					+ " time = " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
