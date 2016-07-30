package com.lzd.thread;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;


/**
 * 使用存取方法返回结果的线程
 * @date 2016年7月26日
 * @author lzd
 *
 */
public class ReturnDigest extends Thread{

	private String filename;
	private byte[] digest;
	

	public ReturnDigest(String filename){
		this.filename = filename;
	}
	
	@Override
	public void run() {
		try {
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream dis = new DigestInputStream(in, sha);
			while(dis.read() != -1);
			dis.close();
			digest = sha.digest();		// 此处获取返回的数据
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public byte[] getDigest() {
		return digest;
	}

}
