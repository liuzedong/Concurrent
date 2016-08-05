package com.lzd.httlSocketServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 提供单个文件的HTTP服务器，无论什么请求，都返回一个指定的文件
 * @date 2016年8月5日
 * @author lzd
 *
 */
public class SingleFileHTTPServer {

	private static final Logger logger = Logger.getLogger("SingleFileHTTPServer");
	
	private final byte[] content;
	private final byte[] header;
	private final int port;
	private final String encoding;
	
	public SingleFileHTTPServer(String data, String encoding, String mimeType, int port) throws UnsupportedEncodingException{
		this(data.getBytes(encoding), encoding, mimeType, port);
	}
	
	public SingleFileHTTPServer(byte[] data, String encoding, String mimeType, int port){
		this.content = data;
		this.port = port;
		this.encoding = encoding;
		String header = "HTTP/1.0 200 OK\r\n"
				+ "Server: OneFile 2.0\r\n"
				+ "Content-length: " + this.content.length + "\r\n"
				+ "Content-type: " + mimeType + "; charset=" + encoding + "\r\n\r\n";
		this.header = header.getBytes(Charset.forName("US-ASCII"));
	}
	
	/**
	 * 主要运行的代码
	 * 
	 * @author 刘泽栋 2016年8月5日 下午3:14:55
	 */
	public void start(){
		// 创建一百个线程的线程池
		ExecutorService pool = Executors.newFixedThreadPool(100);
		try(ServerSocket server = new ServerSocket(this.port)){
			logger.info("Acception connection on port " + server.getLocalPort());
			logger.info("Data to be sent");
			logger.info(new String(this.content, encoding));
			
			while(true){
				Socket connection = server.accept();
				pool.submit(new HTTPHandler(connection));
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Could not start server ", e);
		}
	}

	private class HTTPHandler implements Callable<Void>{

		private final Socket connection;
		
		public HTTPHandler(Socket connection){
			this.connection = connection;
		}
		
		@Override
		public Void call() throws Exception {
			try(
					OutputStream out = new BufferedOutputStream(connection.getOutputStream());
					InputStream in = new BufferedInputStream(connection.getInputStream());
					){
				// 只读取第一行，这是我们需要的全部内容
				StringBuilder request = new StringBuilder();
				while(true){
					int c = in.read();
					if(c == '\r' || c == '\n' || c == -1) break;
					request.append(request);
				}
				// 如果是HTTP/1.0或以后的版本，则发送一个MIME首部
				/*if(request.toString().indexOf("HTTP/") != -1){
					out.write(header);
				}*/
				out.write(header);
				out.write(content);
				
				logger.info(new String(header, "UTF-8") + new String(content, "UTF-8"));
				logger.info(request.toString());
				
				out.flush();
			}catch (Exception e) {
				logger.log(Level.WARNING, "Error writing to client " + e);
			}finally {
				connection.close();
			}
			return null;
		}
	}
	
	/**
	 * 主要的启动方法
	 * @param args
	 * @author 刘泽栋 2016年8月5日 下午3:39:42
	 */
	public static void main(String[] args) {
		// 设置要监听的端口
		int port;
		try {
			port = Integer.parseInt(args[1]);
			if(port < 1 || port > 65535) port =2222; 
		}catch(RuntimeException re){
			port = 2222;
		}
		
		String encoding = "UTF-8";
		if(args.length > 2) encoding = args[2];
		
		try {
			String filepath = "/app/test/epartner_msg_EC16070007.xml";
			Path path = Paths.get(filepath);
			byte[] data = Files.readAllBytes(path);
			
			// 获取文件的MIME类型
			String contentType = URLConnection.getFileNameMap().getContentTypeFor(filepath);
			SingleFileHTTPServer server = new SingleFileHTTPServer(data, encoding, contentType, port);
			server.start();
		}catch(IOException e){
			logger.severe(e.getMessage());
		}
		
	}
	
}
