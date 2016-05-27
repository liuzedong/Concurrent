package com.lzd.two.dirtyRead;
/**
 * 这里，因为睡眠的原因，会先获取到数据
 * 但是，在这之前已经设置了用户名，所以读到了脏数据
 * @date 2016年5月27日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		try {
			PublicVar publicVar = new PublicVar();
			ThreadA thread = new ThreadA(publicVar);
			thread.start();
			Thread.sleep(200);	// 打印结果，受到此值大小的影响
			publicVar.getValue();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
