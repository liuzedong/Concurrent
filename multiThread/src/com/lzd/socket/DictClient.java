package com.lzd.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * 一个基于网络的英语-拉丁语翻译的程序
 * @date 2016年7月30日
 * @author lzd
 */
public class DictClient {
	
	
	public static final String SERVER = "dict.org";
	public static final int PORT = 2628;
	public static final int TIMEOUT = 15000;
	
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket(SERVER, PORT);
			socket.setSoTimeout(TIMEOUT);
			
			// 获得Socket的输出流,并使用缓存和字符写入流进行优化
			OutputStream out = socket.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			writer = new BufferedWriter(writer);
			
			// 获得服务器返回的输入流
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTf-8"));
			
			// 获得用户的输入
			for(String word : args){
				dofine(word, writer, reader);
			}
			writer.write("quit\r\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 施放资源
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 处理 服务器之间对接的信息
	 * @param word
	 * @param writer
	 * @param reader
	 * @throws IOException 
	 */
	private static void dofine(String word, Writer writer, BufferedReader reader) throws IOException {
		// 先向服务器写入信息
		writer.write("DEFINE eng-lat " + word + "\r\n");
		writer.flush();
		
		// 获取服务器返回的信息
		for (String line = reader.readLine(); line != null; line = reader.readLine()){
			if(line.startsWith("250")){	// OK 表示成功啦
				return ;
			}else if(line.startsWith("552")){	// 表示无匹配
				System.out.println("No definition found for " + word);
				return ;
			}else if(line.matches("\\d\\d\\d .*")){
				continue ;
			}else if(line.trim().equals(".")){
				continue ;
			}else {
				System.out.println(line);
			}
		}
	}

}
