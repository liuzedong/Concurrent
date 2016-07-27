package com.lzd.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 简单的实现垃圾回收
 * @date 2016年7月27日
 * @author lzd
 *
 */
public class SpamCheck {
	
	// 此地址是否为垃圾邮件地址
	public static final String BLACKHOLE = "sbl.spamhaus.org";

	/**
	 * 在主程序中给出 地址
	 * @param args
	 * @author 刘泽栋 2016年7月27日 下午2:49:13
	 */
	public static void main(String[] args) {
		for (String arg : args) {
			if(isSpammer(arg)){
				System.out.println(arg + "是存在的");
			}else {
				System.out.println(arg + "是不存在的");
			}
		}
	}
	
	
	private static boolean isSpammer(String arg){
		try {
			InetAddress address = InetAddress.getByName(arg);
			byte[] quad = address.getAddress();
			String query = BLACKHOLE;
			
			for (byte octet : quad) {
				int unsignedByte = octet < 0 ? octet + 256 : octet;
				query = unsignedByte + "." + query;
			}
			InetAddress.getByName(query);
			return true;
		} catch (UnknownHostException e) {
			return false;
		}
	}
}
