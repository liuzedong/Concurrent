package com.lzd.thread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

/**
 * 使用线程去读取文件
 * @date 2016年7月26日
 * @author lzd
 *
 */
public class DigestThread extends Thread{

	private String filename;
	
	public DigestThread(String filename){
		this.filename = filename;
	}
	
	
	@Override
	public void run() {
		try {
			// 获取文件
			FileInputStream in = new FileInputStream(filename);
			// 获取加密算法的实例
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			// 使用sha算法，进行加密流信息
			DigestInputStream din = new DigestInputStream(in, sha);
			// 读取这个文件信息，当文件读取到-1的时候，就读取完成勒文件
			while(din.read() != -1){
				din.close();
				byte[] disgest = sha.digest();
				StringBuilder result = new StringBuilder(filename);
				result.append(": ");
				result.append(DatatypeConverter.printHexBinary(disgest));
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据传入的文件，进行测试
	 * @param args
	 * @author 刘泽栋 2016年7月26日 下午4:43:18
	 */
	public static void main(String[] args) {
		for (String filename : args) {
			Thread t = new DigestThread(filename);
			t.start();
		}
	}
	
}
