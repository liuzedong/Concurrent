package com.lzd.socketServer;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用多线程来处理服务器的连接,这个线程是无限创建的
 * 到达上限时，会内存溢出，应该使用线程池
 * @date 2016年8月2日
 * @author lzd
 *
 */
public class MultithreadedDaytimeServer {
	
	public final static int port = 2222;

	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(port)){
			while(true){
				Socket connection = server.accept();
				
				Thread task = new DayTimeThread(connection);
				task.start();
				
				System.out.println(task.getName());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 每个线程使用这个方法，进行连接
	private static class DayTimeThread extends Thread {
		
		private Socket connection;
		
		DayTimeThread(Socket connection){
			this.connection = connection;
		}

		@Override
		public void run() {
			try (Writer writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");){
				Date now = new Date();
				writer.write("now date : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now));
				writer.write("\r\n");
				writer.flush();
//				System.out.println(Thread.currentThread().getName());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (IOException e) {
					System.out.println("Socket close is Exception");
				}
			}
		}
	}
}
