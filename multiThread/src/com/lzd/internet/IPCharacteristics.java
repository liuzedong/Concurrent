package com.lzd.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 测试IP地址的性质
 * @date 2016年7月27日
 * @author lzd
 *
 */
public class IPCharacteristics {
	
	public static void main(String[] args) {
		String hostname = "127.0.1.1";
		try{
			InetAddress address = InetAddress.getByName(hostname);
			
			if (address.isAnyLocalAddress()){
				System.out.println(address + " is a 通配地址 address ");
			}
			if (address.isLoopbackAddress()){
				System.out.println(address + " is a 回送地址 address ");
			}
			if (address.isLinkLocalAddress()){
				System.out.println(address + " is a IPv6 本地链接地址 address ");
			} else if (address.isSiteLocalAddress()){
				System.out.println(address + " is a IPv6 本地网站地址 address ");
			} else {
				System.out.println(address + " is a gobal address ");
			}
			
			if (address.isMulticastAddress()){
				if (address.isMCGlobal()){
					System.out.println(address + " is a gobal 全球组播地址 address ");
				}else if (address.isMCOrgLocal()){
					System.out.println(address + " is a gobal 组织范围组播地址 address ");
				}else if (address.isMCSiteLocal()){
					System.out.println(address + " is a gobal 网站范围组播地址 address ");
				}else if (address.isMCLinkLocal()){
					System.out.println(address + " is a gobal 子网范围组播地址 address ");
				}else if (address.isMCNodeLocal()){
					System.out.println(address + " is a gobal 本地接口组播地址 address ");
				}else {
					System.out.println(address + " 这个地址不知道是什么类型的 ");
				}
			}
			
			
		}catch(UnknownHostException e){
			System.err.println("Could not resolve : " + hostname);
		}
	}

}
