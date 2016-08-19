package com.lzd.channels;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 一个UDP discard 服务器
 * @date 2016年8月19日
 * @author lzd
 *
 */
public class FastUDPDiscardServer extends UDPServer{

	public final static int DEFAULT_PORT = 1919;
	
	public FastUDPDiscardServer() {
		super(DEFAULT_PORT);
	}
	
	public static void main(String[] args) {
		UDPServer server = new FastUDPDiscardServer();
		Thread t = new Thread(server);
		t.start();
	}

	// 返回信息，这里随便写一点吧
	@Override
	public void respond(DatagramSocket socket, DatagramPacket incoming) throws IOException {
/*		System.out.println("123");
		byte [] data = "hello world".getBytes();
		DatagramPacket outgoing = new DatagramPacket(data, data.length);
		socket.send(outgoing);
*/	}

}
