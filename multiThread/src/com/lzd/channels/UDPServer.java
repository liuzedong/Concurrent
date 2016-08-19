package com.lzd.channels;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * UDP简单的服务器类
 * @date 2016年8月19日
 * @author lzd
 *
 */
public abstract class UDPServer implements Runnable{

	private final int bufferSize;	// 单位为字节
	private final int port;
	private final Logger logger = Logger.getLogger(UDPServer.class.getCanonicalName());
	private volatile boolean isShutDown = false;
	
	
	public UDPServer(int port, int bufferSize){
		this.bufferSize = bufferSize;
		this.port = port;
	}
	
	public UDPServer(int port){
		this(port, 8192);
	}
	
	@Override
	public void run() {
		byte[] buffer = new byte[bufferSize];
		try(DatagramSocket socket = new DatagramSocket(port)){
			while(true){
				socket.setSoTimeout(10000);
				DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
				try {
					socket.receive(incoming);
					this.respond(socket, incoming);
				} catch (Exception e) {
					if (isShutDown) return ;
				}
			}
		} catch (SocketException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		}
	}

	// 让子类实现，进行处理返回结果
	public abstract void respond(DatagramSocket socket, DatagramPacket incoming);
	
	// 使连接关闭
	public void shutDown(){
		this.isShutDown = true;
	}

}
