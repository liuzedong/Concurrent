package com.lzd.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * 基于通道的UDP echo客户端
 * @date 2016年8月19日
 * @author lzd
 *
 */
public class UDPEchoClientWithChannels {
	
	private final static int PORT = 1919;
	private final static int LIMIT = 100;
	
	public static void main(String[] args) {
		SocketAddress remote;
		try {
			remote = new InetSocketAddress(args[0], PORT);
		} catch (RuntimeException e) {
			System.out.println("Uage : Java UDPEchoClientWithChannels host");
			return ;
		}
		
		try (DatagramChannel channel = DatagramChannel.open()){
			// 使用非阻塞的通道
			channel.configureBlocking(false);
			// 连接远程地址，打开连接
			channel.connect(remote);
			
			Selector selector = Selector.open();
			channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
			
			// 创建缓冲区
			ByteBuffer buffer = ByteBuffer.allocate(4);
			int n = 0;
			int numbersRead = 0;
			while(true){
				if (numbersRead == LIMIT) break;
				// 为一个连接等待一分钟
				selector.select(60000);
				Set<SelectionKey> readyKeys = selector.selectedKeys();
				if (readyKeys.isEmpty() && n == LIMIT){
					// 所有包已经写入，看起来好像不会再有更多数据从网络到达
					break ;
				} else {
					Iterator<SelectionKey> iterator = readyKeys.iterator();
					while(iterator.hasNext()){
						SelectionKey key = iterator.next();
						iterator.remove();
						if(key.isReadable()){
							buffer.clear();
							channel.read(buffer);
							buffer.flip();
							// 此处只获取int的值
							int echo = buffer.getInt();
							System.out.println("Read " + echo);
							numbersRead++;
						} else if (key.isWritable()){
							buffer.clear();
							buffer.putInt(n);
							buffer.flip();
							channel.write(buffer);
							System.out.println("Wrote " + n);
							n++;
							if(n == LIMIT){
								// 所有包已写入，切换到只读模式
								key.interestOps(SelectionKey.OP_READ);
							}
						}
					}
				}
			}
			System.out.println("Echo " + numbersRead  + " out of " + LIMIT + " sent ");
			System.out.println("Success rate: " + 100.0 * numbersRead /LIMIT + "%");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
