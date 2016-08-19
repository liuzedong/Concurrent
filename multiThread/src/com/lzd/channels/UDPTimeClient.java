package com.lzd.channels;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * 一个UDP time客户端
 * @date 2016年8月19日
 * @author lzd
 *
 */
public class UDPTimeClient {

	public final static int PORT = 37;
	public final static String DEFAULT_HOST = "time.nist.gov";
	
	/**
	 * 使用UDP协议 调用时间服务器
	 * @param args
	 * @author 刘泽栋 2016年8月19日 上午11:13:56
	 */
	public static void main(String[] args) {
		InetAddress host;
		try {
			if (args.length > 0){
				host = InetAddress.getByName(args[0]);
			} else {
				host = InetAddress.getByName(DEFAULT_HOST);
			}
		} catch (UnknownHostException e) {
			System.out.println("Uasge ： java UDPTimeClient [host] ");
			return ;
		}
		
		UDPPoke poker = new UDPPoke(host, PORT);
		byte[] response = poker.poke();
		if(response == null){
			System.out.println("No response within allotted time");
			return ;
		}
		
		// time 协议的起点是1990年
		// java Date类的起点的是1970年
		// 利用这个数字可以在两者之间进行转换
		long differenceBetweenEpochs = 2208988800L;
		long secondsSince1900 = 0;
		
		for (int i = 0; i < 4; i++) {
			secondsSince1900 = (secondsSince1900 << 8) | (response[i] & 0x000000FF);
		}
		
		long secondsSince1970 = secondsSince1900 - differenceBetweenEpochs;
		long msSince1970 = secondsSince1970 * 1000;
		Date time = new Date(msSince1970);
		
		System.out.println(time);
		
	}
	
	
}
