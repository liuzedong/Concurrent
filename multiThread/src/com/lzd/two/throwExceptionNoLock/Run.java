package com.lzd.two.throwExceptionNoLock;
/**
 * 当线程执行代码出现异常时，其所持有的锁会自动释放
 * @date 2016年5月31日
 * @author lzd
 *
 */
public class Run {
	
	public static void main(String[] args) {
		try {
			Service service = new Service();
			ThreadA a = new ThreadA(service);
			a.setName("a");
			a.start();
			Thread.sleep(500);
			ThreadB b = new ThreadB(service);
			b.setName("b");
			b.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
