package com.lzd.two.twoStop;
/**
 * 同步方法容易造成死锁。同步synchronized方法无线等待与解决
 * @date 2016年6月2日
 * @author lzd
 *
 */
public class Service {

	/*// 线程运行该方法，会一直执行，其他方法会处于等待状态
	synchronized public void methodA(){
		System.out.println("methodA begin");
		boolean isContinueRun = true;
		while(isContinueRun){
			
		}
		System.out.println("methodA end");
	}
	
	// 另外一个同步的方法
	synchronized public void methodB(){
		System.out.println("MethdoB begin");
		System.out.println("MethodB end");
	}
	*/
	
	// 上面的方法会造成死锁，下面的方法  使用方法块，各自使用一个锁
	Object object1 = new Object();
	public void methodA(){
		synchronized(object1){
			System.out.println("methodA begin");
			boolean isContinueRun = true;
			while(isContinueRun){
				
			}
			System.out.println("methodA end");
		}
	}
	
	Object object2 = new Object();
	public void methodB(){
		synchronized(object2){
			System.out.println("MethdoB begin");
			System.out.println("MethodB end");
		}
	}
}
