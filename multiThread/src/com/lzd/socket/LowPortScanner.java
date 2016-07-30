package com.lzd.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 查看指定主机上前1024个端口中那些端口安装勒TCP服务器
 * @date 2016年7月30日
 * @author lzd
 */
public class LowPortScanner {
	
	private static final String HOST = "www.liuzedong.com";
	
	public static void main(String[] args) {
		for(int i = 1; i< 1024; i++){
			try {
				Socket socket = new Socket(HOST, i);
				System.out.println("There is a server on port " + i + " of " + HOST);
				socket.close();
			} catch (UnknownHostException e) {
				System.err.println(e);
				break;
			} catch (IOException e) {
				// 这个端口不是一个服务器
//				System.err.println("错");
			}
			
		}
	}

}
