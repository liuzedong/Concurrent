package com.lzd.channels;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP 的 echo客户端，接收数据
 * @date 2016年8月19日
 * @author lzd
 *
 */
public class ReceiverThread extends Thread{

	private DatagramSocket socket;
	private volatile boolean stopped = false;
	
	ReceiverThread(DatagramSocket socket){
		this.socket = socket;
	}
	
	public void halt(){
		this.stopped = true;
	}
	
	@Override
	public void run() {
		byte[] buffer = new byte[65507];
		while(true){
			if (stopped) return ;
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			
			try {
				socket.receive(dp);
				String s = new String(dp.getData(), 0, dp.getLength(), "UTF-8");
				System.out.println(s);
				Thread.yield();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
