package com.lzd.tell;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端向服务端发送信息的线程
 * @date 2016年9月20日
 * @author lzd
 *
 */
public class ClientSend extends Thread{
	
	private Scanner scanner;
	private Socket socket;
	
	public ClientSend(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		scanner =  new Scanner(System.in);
		try {
			PrintStream ps = new PrintStream(socket.getOutputStream());
			String line = "";
			// 阻塞发送信息
			while ((line = scanner.nextLine()) != null){
				System.out.println(line);
				ps.print(line);
				ps.flush();
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
