package com.lzd.two.twoObjectTwoLock;
/**
 * 当创建两个对象的时候，会创建两个锁，所以会操作数据不同步
 * 要么在HasSelfPrivateNum  对象需要同步的方法上面添加synchronized 关键字，要么
 * 就创建两个类，分别进行传入，这样就会有两个锁啦
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
//		HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
		ThreadA threadA = new ThreadA(numRef1);
		threadA.start();
		
		ThreadB threadB = new ThreadB(numRef1);
		threadB.start();
	}
}
