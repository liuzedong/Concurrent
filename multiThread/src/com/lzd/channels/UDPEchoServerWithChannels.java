package com.lzd.channels;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * 一个基于channel的UDP 上echo协议的服务器
 * 将用户输入的，返回给用户
 * 就是我们接收到的数据，再把这些数据原封不动的返回给用户
 * @date 2016年8月19日
 * @author lzd
 *
 */
public class UDPEchoServerWithChannels {

	private final static int PORT = 1919;
	private final static int MAX_PACKET_SIZE = 65507;
	
	public static void main(String[] args) {
		try {
			DatagramChannel channel = DatagramChannel.open();
			DatagramSocket socket = channel.socket();
			SocketAddress address = new InetSocketAddress(PORT);
			socket.bind(address);
			ByteBuffer buffer = ByteBuffer.allocateDirect(MAX_PACKET_SIZE);
			while(true){
				SocketAddress client = channel.receive(buffer);
				buffer.flip();
				// 将用户的数据，原封不动的返回给用户
				channel.send(buffer, client);
				buffer.clear();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
}
