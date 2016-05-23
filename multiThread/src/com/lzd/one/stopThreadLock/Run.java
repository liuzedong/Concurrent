package com.lzd.one.stopThreadLock;
/**
 * 测试Stop的数据不一致性的启动类
 * 线程停止前，SynchronizedObject对象里面的数据，已经改变了
 * @date 2016年5月23日
 * @author lzd
 *
 */
public class Run {
	public static void main(String[] args) {
		try{
			SynchronizedObject object = new SynchronizedObject();
			MyThread thread = new MyThread(object);
			thread.start();
			thread.sleep(500);
			thread.stop();
			System.out.println(object.getUsername() + ", " + object.getPassword());
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
