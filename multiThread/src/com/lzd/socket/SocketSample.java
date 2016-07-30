package com.lzd.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Socket的一些使用示例
 * @date 2016年7月30日
 * @author lzd
 */
public class SocketSample {
	
	public static void main(String[] args) {
		// 设置地址和端口，自动链接，没有链接上，就会抛出异常
		try(Socket s = new Socket("www.baidu.com", 13))	{
			s.setSoTimeout(15000);
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
