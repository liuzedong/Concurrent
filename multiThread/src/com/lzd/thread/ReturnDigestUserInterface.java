package com.lzd.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * 使用存储方法获得线程输出的主程序
 * @date 2016年7月26日
 * @author lzd
 *
 */
public class ReturnDigestUserInterface {

	public static void main(String[] args) throws InterruptedException {
		for (String filename : args) {
			// 计算摘要
			ReturnDigest dr = new ReturnDigest(filename);
			dr.start();
			
			Thread.sleep(1000);
			
			// 显示结果信息
			StringBuilder result = new StringBuilder(filename);
			result.append(": ");
			byte[] digest = dr.getDigest();
			
			result.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(result);
			
		}
	}
	
}
