package com.lzd.channels;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 简单的UDP 客户端
 * @date 2016年8月19日
 * @author lzd
 *
 */
public class UDPPoke {
	
	private int bufferSize;	// 单位为字节
	private int timeout;	// 单位为毫秒
	private InetAddress host;
	private int port;
	
	public UDPPoke(InetAddress host, int port, int bufferSize, int timeout){
		this.bufferSize = bufferSize;
		this.host = host;
		if (port < 1 || port > 65535){
			throw new IllegalArgumentException("Port out of range");
		}
		this.port = port;
		this.timeout = timeout;
	}

	/**
	 * 如果没有超时时间，默认为3000
	 * @param host 主机
	 * @param port 端口
	 * @param bufferSize 缓冲区大小
	 */
	public UDPPoke(InetAddress host, int port, int bufferSize){
		this(host, port, bufferSize, 3000);
	}
	
	/**
	 * 如果没有缓冲区大小，默认为8192和默认时间3000
	 * @param host 主机
	 * @param port 端口
	 */
	public UDPPoke(InetAddress host, int port){
		this(host, port, 8192, 3000);
	}
	
	/**
	 *  发送数据和接收数据
	 * @return
	 * @author 刘泽栋 2016年8月19日 上午10:32:43
	 */
	public byte[] poke(){
		try(DatagramSocket socket = new DatagramSocket(0)){
			DatagramPacket outgoing = new DatagramPacket(new byte[1], 1, host, port);
			socket.connect(host, port);
			socket.setSoTimeout(timeout);
			socket.send(outgoing);
			
			// 接收的数据
			DatagramPacket incoming = new DatagramPacket(new byte[bufferSize], bufferSize);
			// 下一行阻塞，直到接收到请求
			socket.receive(incoming);
			// 数据的长度
			int numBytes = incoming.getLength();
			byte[] response = new byte[numBytes];
			System.arraycopy(incoming.getData(), 0, response, 0, numBytes);
			return response;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 主要的调用方法
	 * @param args
	 * @author 刘泽栋 2016年8月19日 上午10:32:30
	 */
	public static void main(String[] args) {
		InetAddress host;
		int port = 0;
		try {
			host = InetAddress.getByName(args[0]);
			port = Integer.parseInt(args[1]);
		} catch (UnknownHostException e) {
			System.out.println("Uasge ： java UDPPoke host port ");
			return ;
		}
		
		UDPPoke poke = new UDPPoke(host, port);
		byte[] response = poke.poke();
		if(response == null){
			System.out.println("No response within allotted time");
			return ;
		}

		try {
			String result = new String(response, "US-ASCII");
			System.out.println(result);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
}
