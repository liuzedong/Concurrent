package com.lzd.channels;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 使用UDP 的echo客户端
 * @date 2016年8月19日
 * @author lzd
 *
 */
public class UDPEchoClient {

	public final static int PORT = 1919;
	
	public static void main(String[] args) {
		String hostname = "localhost";
		if(args.length > 0){
			hostname = args[0];
		}
		
		try {
			InetAddress ia = InetAddress.getByName(hostname);
			DatagramSocket socket = new DatagramSocket();
			// 发送请求
			SenderThread sender = new SenderThread(socket, ia, PORT);
			sender.start();
			// 接收请求
			Thread receiver = new ReceiverThread(socket);
			receiver.start();
		} catch (UnknownHostException | SocketException e) {
			e.printStackTrace();
		}
		
		
	}
}
