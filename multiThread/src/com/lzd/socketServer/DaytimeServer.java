package com.lzd.socketServer;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用socketserver实现时间服务器
 * @date 2016年8月1日
 * @author lzd
 *
 */
public class DaytimeServer {

	public final static int PORT = 2222;
	
	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(PORT)){
			// 死循环 一直读取 连接
			while(true){
				try(Socket connection = server.accept()){
					Writer out = new OutputStreamWriter(connection.getOutputStream());
					Date now = new Date();
					
					out.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now).toString() + "\r\n");
					out.flush();
					
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
