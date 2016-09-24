package com.lzd.tell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端接受信息的线程
 * @date 2016年9月20日
 * @author lzd
 *
 */
public class ClientReceive extends Thread{

	private Socket socket;
	
	public ClientReceive(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 按行接收
			String line = "";
			while ((line = br.readLine()) != null){
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
