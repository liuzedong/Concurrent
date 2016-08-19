package com.lzd.channels;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * 基于通道的UDPDiscardServer 服务器
 * @date 2016年8月19日
 * @author lzd
 *
 */
public class UDPDiscardServerWithChannels {
	
	public final static int PORT = 19;
	public final static int MAX_PACKET_SIZE = 65507;
	
	/**
	 * 启动程序，基于channel的UDP
	 * @param args
	 * @author 刘泽栋 2016年8月19日 下午3:52:39
	 */
	public static void main(String[] args) {
		try {
			DatagramChannel channel = DatagramChannel.open();
			DatagramSocket socket = channel.socket();
			SocketAddress address = new InetSocketAddress(PORT);
			socket.bind(address);
			ByteBuffer buffer = ByteBuffer.allocateDirect(MAX_PACKET_SIZE);
			while(true){
				// 通道中的数据，放入到这个缓冲区中
				SocketAddress client = channel.receive(buffer);
				buffer.flip();
				System.out.println(client + " says ");
				// 查看缓冲区中是否有值，如果有值，就一直输出
				while(buffer.hasRemaining()) System.out.write(buffer.get());
				// 换行
				System.out.println();
				buffer.clear();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
