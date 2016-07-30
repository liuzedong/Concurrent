package com.lzd.internet;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * 获取网卡的信息
 * @date 2016年7月27日
 * @author lzd
 *
 */
public class GetNetworkInterface {
	
	public static void main(String[] args) {
		try {
			NetworkInterface network = NetworkInterface.getByName("wlan0");
//			NetworkInterface network1 = NetworkInterface.getByIndex(3);
			System.out.println(network.getDisplayName());
//			System.out.println(network1);
			System.out.println(network.getIndex());
			System.out.println(network.getMTU());
			System.out.println(network.isUp());
			System.out.println(network.supportsMulticast());
			System.out.println(network.getInetAddresses().nextElement().getHostAddress());
			
			InetAddress address = InetAddress.getByName("101.200.187.53");
			NetworkInterface network2 = NetworkInterface.getByInetAddress(address);
			System.out.println(network2);
			
			// 列出所有网络接口的程序
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while(networkInterfaces.hasMoreElements()){
				NetworkInterface nextElement = networkInterfaces.nextElement();
				System.out.println("当前机器的网络卡信息：" + nextElement);
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
