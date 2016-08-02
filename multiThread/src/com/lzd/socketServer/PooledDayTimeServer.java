package com.lzd.socketServer;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器使用线程池，而非使用线程，无限的创建
 * @date 2016年8月2日
 * @author lzd
 *
 */
public class PooledDayTimeServer {
	
	public final static int PORT = 2222;
	
	public static void main(String[] args) {
		// 创建线程池50个
		ExecutorService pool = Executors.newFixedThreadPool(50);
		
		try(ServerSocket server = new ServerSocket(PORT);){
			while(true){
				Socket connection = server.accept();
				Callable<Void> task = new DayTimeTask(connection);
				System.out.println(Thread.currentThread().getName());
				pool.submit(task);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class DayTimeTask implements Callable<Void>{
		private Socket connection;
		
		DayTimeTask(Socket connection) {
			this.connection = connection;
		}

		@Override
		public Void call() throws Exception {
			try(Writer out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8")){
				out.write("Now Date is : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\r\n");
				out.flush();
			}finally {
				connection.close();
			}
			
			return null;
		}
	}
}
