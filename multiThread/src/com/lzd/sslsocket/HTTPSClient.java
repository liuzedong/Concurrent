package com.lzd.sslsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * 安全的Socket，使用这个Socket对数据进行加密啦
 * @date 2016年8月8日
 * @author lzd
 *
 */
public class HTTPSClient {

	public static void main(String[] args) {
		if (args.length == 0){
			System.out.println("Usage: Java HTTPSClient2 host");
			return ;
		}
		
		// 设置默认端口
		int port = 443;
		String host = args[0];
		
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket socket = null;
		
		try{
			socket = (SSLSocket) factory.createSocket(host, port);
			
			// 启动所有密码组，查询出所有的密码组，再设置进去
			String[] supported = socket.getSupportedCipherSuites();
			socket.setEnabledCipherSuites(supported);
			
			Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			// https在GET行中需要完全URL
			out.write("GET http://" + host + "/ HTTP/1.1\r\n");
			out.write("Host: " + host + "\r\n");
			out.write("\r\n");
			out.flush();
			
			
			// 读取响应
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			// 读取首部
			String s;
			while(!(s = in.readLine()).equals("")){
				System.out.println(s);
			}
			System.out.println();
			
			// 读取长度
			String contentLength = in.readLine();
			int length = Integer.MAX_VALUE;
			try{
				length = Integer.parseInt(contentLength.trim(), 16);
			}catch (NumberFormatException ex){
				// 这个服务器在响应体的第一行，没有发送content-length
			}
			System.out.println(contentLength);
			
			// 去读消息体
			int c;
			int i = 0;
			while((c = in.read()) != -1 && i++ < length){
				System.out.print((char)c);
			}
			System.out.println();
			
			
			
			
		}catch (IOException e){
			System.err.println(e);
		}finally {
			try {
				if(socket != null) socket.close();
			} catch (IOException e) {}
		}
		
		
	}
	
}
