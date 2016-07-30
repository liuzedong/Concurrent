package com.lzd.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 根据域名或者IP来获取地址
 * @date 2016年7月27日
 * @author lzd
 *
 */
public class OReillyByName {
	
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("www.baidu.com");
			System.out.println("百度地址：" + address);
			
			InetAddress address2 = InetAddress.getByName("115.159.234.15");
			System.out.println("百度地址：" + address2.getHostName() + "," + address2.getHostAddress());
			
			// 获取百度的所有地址
			InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
			for (InetAddress inetAddress : addresses) {
				System.out.println("百度地址：" + inetAddress);
			}
			
			// 查找本机的ip地址
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println(localHost);
			
			
			// 查找ip所对应的主机名称
			InetAddress ia = InetAddress.getByName("218.12.228.248");
			System.out.println(ia.getHostName() + " : " + ia.getCanonicalHostName());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
