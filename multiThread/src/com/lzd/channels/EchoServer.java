package com.lzd.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Echo服务器，客户端输入什么，返回什么，这个是基于channel来实现的
 * @date 2016年8月17日
 * @author lzd
 *
 */
public class EchoServer {
	
	public static int DEFAULT_PORT = 1919;
	
	public static void main(String[] args) {
		int port;
		
		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			port = DEFAULT_PORT;
		}
		System.out.println("Lintening for connection on port " + port);
		
		ServerSocketChannel serverSocketChannel;
		Selector selector;
		try {
			// 创建通道，以及获取通道中的ServerSocket
			serverSocketChannel = ServerSocketChannel.open();
			ServerSocket ss = serverSocketChannel.socket();
			// 绑定端口
			InetSocketAddress address = new InetSocketAddress(port);
			ss.bind(address);
			// 开启异步
			serverSocketChannel.configureBlocking(false);
			selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
			return ;
		}
		
		while(true){
			try { // 打开连接
				selector.select();
			} catch (IOException e) {
				e.printStackTrace();
				break ;
			}
			
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readyKeys.iterator();
			while(iterator.hasNext()){
				SelectionKey key = iterator.next();
				iterator.remove();
				
				try {
					if(key.isAcceptable()){// 初次链接进入
						ServerSocketChannel server = (ServerSocketChannel) key.channel();
						SocketChannel client = server.accept();
						System.out.println("Accepted connection from " + client);
						client.configureBlocking(false);
						SelectionKey clientKey = client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
						ByteBuffer buffer = ByteBuffer.allocate(100);
						clientKey.attach(buffer);
					}else if (key.isReadable()){// 读取数据
						// 获取到客户端的通道，获取到客户端输入的数据
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer output = (ByteBuffer) key.attachment();
						client.read(output);
					} else if (key.isWritable()){ // 写入客户端
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer output = (ByteBuffer) key.attachment();
						output.flip();
						client.write(output);
						output.compact();
					}
				} catch (Exception e) {
					key.cancel();
					try {
						key.channel().close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				
			}
			
		}
		
	}

}
