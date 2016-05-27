package com.lzd.two.synLockIn_1;
/**
 * 锁重入，一个对象获取锁，可以再次获取该对象的锁
 * "可重入锁"的概念：自己可以再次获取到自己的内部锁。比如有1条线程得到某个对象的锁，
 * 				此时这个对象锁还没有释放，当其再次想要获取这个对象的锁的时候还是可以获取的。
 * 				如果不可锁重入的话，就会造成死锁
 * @date 2016年5月27日
 * @author lzd
 *
 */
public class Service {
	
	synchronized public void service1(){
		System.out.println("service1");
		service2();
	}
	
	synchronized public void service2(){
		System.out.println("service2");
		service3();
	}
	
	synchronized public void service3(){
		System.out.println("service3");
	}

}
