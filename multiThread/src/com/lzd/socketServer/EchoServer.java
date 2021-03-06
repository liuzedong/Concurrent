package com.lzd.socketServer;

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
 * Echo服务器，使客户端与服务端进行交互
 * @date 2016年8月2日
 * @author lzd
 *
 */
public class EchoServer {

	public static final int DEFAULT_PORT = 2222;
	
	public static void main(String[] args) {
		int port;
		
		try{
			port = Integer.parseInt(args[0]);
		}catch (RuntimeException e){
			port = DEFAULT_PORT;
		}
		
		System.out.println("Listening for connections on port : " + port);
		
		ServerSocketChannel serverChannel;
		Selector selector;
		
		try{
			serverChannel = ServerSocketChannel.open();
			ServerSocket ss = serverChannel.socket();
			InetSocketAddress address = new InetSocketAddress(port);
			ss.bind(address);
			serverChannel.configureBlocking(false);
			selector = Selector.open();
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		}catch(IOException e){
			e.printStackTrace();
			return;
		}
		
		while(true){
			try {
				selector.select();
			} catch (IOException e) {
				e.printStackTrace();
				return ;
			}
			
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readyKeys.iterator();
			
			while(iterator.hasNext()){
				SelectionKey key = iterator.next();
				iterator.remove();
				
				try{
					if(key.isAcceptable()){
						ServerSocketChannel server = (ServerSocketChannel) key.channel();
						SocketChannel client = server.accept();
						System.out.println("Accepted connection from : " + client);
						client.configureBlocking(false);
						SelectionKey clientKey = client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
						ByteBuffer buffer = ByteBuffer.allocate(100);
						clientKey.attach(buffer);
					}
					// 检测 客户端写入的信息
					if(key.isReadable()){
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer output = (ByteBuffer) key.attachment();
						client.read(output);
					}
					// 向客户端 写出，他写入的信息
					if(key.isWritable()){
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer output = (ByteBuffer) key.attachment();
						output.flip();
						client.write(output);
						output.compact();
					}
				}catch (Exception e) {
					
				}
				
				
			}
			
		}
	}
}
