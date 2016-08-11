package com.lzd.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 一个基于通道的 客户端
 * @date 2016年8月11日
 * @author lzd
 *
 */
public class ChannelClient {
	
	private static int DEFAULT_PORT = 80;
	
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Usage: Java ChargenClient host [port]");
			return ;
		}
		
		int port;
		try{
			port = Integer.parseInt(args[1]);
		}catch(RuntimeException e){
			port = DEFAULT_PORT;
		}
		
		SocketAddress address = new InetSocketAddress(args[0], port);
		try {
			SocketChannel client = SocketChannel.open(address);
			
			ByteBuffer buffer = ByteBuffer.allocate(74);
			WritableByteChannel out = Channels.newChannel(System.out);
			
			while(client.read(buffer) != -1){
				buffer.flip();
				out.write(buffer);
				buffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
