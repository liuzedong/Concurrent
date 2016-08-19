package com.lzd.channels;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 一个UDP echo服务器
 * @date 2016年8月19日
 * @author lzd
 *
 */
public class UDPEchoServer extends UDPServer{

	public final static int DEFAULT_PORT = 1919;
	
	public UDPEchoServer(){
		super(DEFAULT_PORT);
	}
	
	// 返回用户输入的
	@Override
	public void respond(DatagramSocket socket, DatagramPacket incoming)
			throws IOException {
		System.out.println("you are coming ... ");
		DatagramPacket outgoing = new DatagramPacket(incoming.getData(), incoming.getLength(),
				incoming.getAddress(), incoming.getPort());
		socket.send(outgoing);
	}

	
	/**
	 * 启动的方法
	 * @param args
	 * @author 刘泽栋 2016年8月19日 下午2:47:18
	 */
	public static void main(String[] args) {
		UDPServer server = new UDPEchoServer();
		Thread t = new Thread(server);
		t.start();
	}
	
}
