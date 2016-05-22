package com.lzd.one.mythread;
/**
 * 使用stop停止线程，会抛出ThreadDeath异常，现在演示这个异常
 * stop方法已经被废弃啦，因为强行停止线程，可能使一些清理工作得不到完成。
 * 另外一种情况就是对锁定的对象进行“解锁”，导致数据得不到同步处理，出现数据不一致的问题
 * @date 2016年5月22日
 * @author lzd
 */
public class MyThread13 extends Thread{

	@Override
	public void run() {
		try{
			this.stop();
		}catch(ThreadDeath e){
			e.printStackTrace();
		}
		super.run();
	}

}
