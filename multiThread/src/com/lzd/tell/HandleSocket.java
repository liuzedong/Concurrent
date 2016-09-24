package com.lzd.tell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

/**
 * 处理每个(单个)连接到服务器的客户端的线程
 * @date 2016年9月20日
 * @author lzd
 *
 */
public class HandleSocket extends Thread{
	
	private Socket socket;
	private List<Socket> list;
	
	public HandleSocket(Socket socket, List<Socket> list){
		this.socket = socket;
		this.list = list;
	}

	
	@Override
	public void run() {
		// 获取连接到服务器的这个客户端地址
		InetAddress address = socket.getInetAddress();
		String ip = address.getHostAddress();
		System.out.println(ip + "连接上啦");
		if (ip.endsWith("192.168.1.111")){
			synchronized (list){
				sendToAll(ip + "由于违规操作，已经被拉入黑名单");
				list.remove(socket);
				return ;
			}
		}
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "gbk"));
			String line = "";
			while ((line = br.readLine()) != null){
				String msg = ip + ":" + line;
				System.out.println(msg);
				// 把这个客户端说的话，发给其他所有的客户端
				sendToAll(msg);
			}
		}  catch (IOException e) {
			System.out.println(ip + "下线啦");
			synchronized (list){
				list.remove(socket);
			}
		}
		
	}
	
	/**
	 * 把信息发送给所有的客户端，去掉当前的socket
	 * @param msg
	 * @author 刘泽栋 2016年9月20日 下午2:32:18
	 */
	private void sendToAll(String msg){
		synchronized (list){
			for (Socket s : list) {
				if (s != null){
					try {
						PrintStream ps = new PrintStream(s.getOutputStream());
						ps.print(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
