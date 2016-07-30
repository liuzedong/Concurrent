package com.lzd.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * 使用轮循的方式，获取值，上一个方法，是在获取值的时候添加休眠线程
 * 这个方法，是使用一直查询是否有值
 * @date 2016年7月26日
 * @author lzd
 *
 */
public class ReturnDigestUserInterface2 {

	public static void main(String[] args) throws InterruptedException {
		// 计算摘要
		ReturnDigest[] digests = new ReturnDigest[args.length];
		for (int i = 0; i < args.length; i++) {
			digests[i] = new ReturnDigest(args[i]);
			digests[i].start();
		}

//		Thread.sleep(1000);
		
		// 显示结果
		for (int i = 0; i < args.length; i++) {
			while(true){
				byte[] digest = digests[i].getDigest();
				if(digest != null){
					StringBuilder result = new StringBuilder(args[i]);
					result.append(": ");
					result.append(DatatypeConverter.printHexBinary(digest));
					System.out.println(result);
					break;
				}
			}
		}
		
	}
	
}
