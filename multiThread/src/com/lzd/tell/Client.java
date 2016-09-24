package com.lzd.tell;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * @date 2016年9月20日
 * @author lzd
 *
 */
public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("127.0.0.1", 10000);
		
		// 创建发送信息的线程
		new ClientSend(client).start();
		// 创建接受信息的线程
		new ClientReceive(client).start();
	}
	
}
