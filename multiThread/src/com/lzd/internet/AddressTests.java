package com.lzd.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 确定IP地址是IPv4还是IPv6
 * @date 2016年7月27日
 * @author lzd
 *
 */
public class AddressTests {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress ia = InetAddress.getByName("www.baidu.com");
		System.out.println(ia);
		byte[] address = ia.getAddress();
		if(address.length == 4){
			System.out.println("this is IPv4 : " + addressToAddress(address));
		}else if (address.length == 6){
			System.out.println("this is IPv6 : " + addressToAddress(address));
		}else {
			System.err.println("This is not IPv4 or IPv6");
		}
	}
	
	/**
	 * 把中间的IPv4地址转换，因为其中有负数
	 * @param address
	 * @return
	 * @author 刘泽栋 2016年7月27日 上午10:41:27
	 */
	public static String addressToAddress(byte[] address){
		int[] tmp = new int[address.length];
		for (int i = 0; i < address.length; i++) {
			tmp[i] = address[i];
			tmp[i] = tmp[i] < 0 ? tmp[i] + 256 : tmp[i];
		}
		
		return Arrays.toString(tmp);
	}
	
}
