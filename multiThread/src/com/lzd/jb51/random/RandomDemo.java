package com.lzd.jb51.random;

import java.util.Random;

/**
 * 获取随机数的三种方法
 * @author lzd
 * @date 2016年9月28日下午11:45:22
 */
public class RandomDemo {

	
	public static void main(String[] args) {
		timeRandom();
		mathRandom();
		randomAPIs();
	}
	
	/**
	 * 第一种是使用当前时间来获取随机数的
	 * 1475077947518%100 = 18，就是后面两个数字
	 * @return
	 * @date 2016年9月28日下午11:46:21
	 */
	public static String timeRandom(){
		final long l = System.currentTimeMillis();
		// 获得1-100之间的随机数。
		final int randomNum = (int) (l % 100);
//		System.out.println("now time millis : " + l + "%" + "100 = " + randomNum);
		return String.valueOf(randomNum);
	}
	
	/**
	 * 第二种使用Math类的random方法
	 * @return
	 * @date 2016年9月28日下午11:55:14
	 */
	public static String mathRandom(){
		// 这个返回的是0-1之间的一个double随机数
		final double d = Math.random();
		int randomNum = (int) (d * 100);
//		System.out.println("第二种方法：" + d + "*" + "100 = " + randomNum);
		return String.valueOf(randomNum);
	}
	
	/**
	 * 第三种使用Random类进行生成随机数
	 * @return
	 * @date 2016年9月29日上午12:01:44
	 */
	public static String randomAPIs(){
		Random random = new Random();
		int randomNum = random.nextInt(100);
//		System.out.println("第三种方法：" + randomNum);
		return String.valueOf(randomNum);
	}
	
}
