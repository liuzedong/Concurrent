package com.lzd.tell;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务器
 * @date 2016年9月20日
 * @author lzd
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		List<Socket> list = new ArrayList<Socket>();
		
		// 创建服务器端的套接字
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(10000);
		
		while (true){
			// 接收客户端的阻塞方法
			Socket socket = server.accept();
			// 设计到多个线程可能会对集合进行增删的操作，要进行同步的处理
			synchronized(list){
				list.add(socket);
			}
			// 启动一个新的线程去处理这个客户端的交流
			new HandleSocket(socket, list).start();
		}
		
	}
	
}
