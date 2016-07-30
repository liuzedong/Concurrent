package com.lzd.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Daytime协议客户端
 * @date 2016年7月30日
 * @author lzd
 */
public class DaytimeClient {
	
	
	public static void main(String[] args) {
		// 服务端地址
		String hostname = "time.nist.gov";
		
		Socket socket = null;
		try{
			// 链接服务器
			socket = new Socket(hostname, 13);
			// 设置超时时间
			socket.setSoTimeout(15000);
			// 获得服务起返回的输入流
			InputStream in = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(in, "ASCII");
			
			// 用来装返回的数据
			StringBuffer time = new StringBuffer();
			// 读取返回的信息
			for(int c = reader.read(); c != -1; c = reader.read()){
				time.append((char) c);
			}
			System.out.println();
		}catch (IOException e){
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				// 直接忽视啦
			}
		}
		
	}

}
