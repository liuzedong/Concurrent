package com.lzd.channels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP发送数据
 * @date 2016年8月19日
 * @author lzd
 *
 */
public class SenderThread extends Thread{
	
	private InetAddress server;
	private DatagramSocket socket;
	private int port;
	private volatile boolean stopped = false;
	
	SenderThread(DatagramSocket socket, InetAddress address, int port){
		this.server = address;
		this.socket = socket;
		this.port = port;
		this.socket.connect(server, port);
	}

	
	public void halt(){
		this.stopped = true;
	}


	@Override
	public void run() {
		try {
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			while (true){
				if (stopped) return;
				String theLine = userInput.readLine();
				if (".".equals(theLine)) break ;
				byte[] data = theLine.getBytes("UTF-8");
				DatagramPacket output = new DatagramPacket(data, data.length, server, port);
				socket.send(output);
				Thread.yield();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
}
