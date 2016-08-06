package com.lzd.httlSocketServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestProcessor implements Runnable{
	
	private static final Logger logger = Logger.getLogger(RequestProcessor.class.getCanonicalName());
	
	private File rootDirector;
	private String indexFileName = "index.html";
	private Socket connection;
	
	public RequestProcessor(File rootDirector, String indexFileName, Socket connection) {
		if (rootDirector.isFile()){
			throw new IllegalArgumentException("rootDirector 必须是一个目录，不可以是一个文件");
		}
		try {
			rootDirector = rootDirector.getCanonicalFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.rootDirector = rootDirector;
		if (indexFileName != null) this.indexFileName = indexFileName;
		this.connection = connection;
	}
	

	/**
	 * 线程用来处理每个请求
	 */
	@Override
	public void run() {
		// 安全检查
		String root = rootDirector.getPath();
		try(OutputStream raw = new BufferedOutputStream(connection.getOutputStream());
				Writer out = new OutputStreamWriter(raw);
				Reader in = new InputStreamReader(new BufferedInputStream(connection.getInputStream()), "US-ASCII");
				){
			// 获取请求的第一行
			StringBuilder requestLine = new StringBuilder();
			while(true){
				int c = in.read();
				if (c == '\r' || c == '\n') break;
				requestLine.append((char) c);
			}
			
			// 请求的第一行
			String get = requestLine.toString();
			
			logger.info(connection.getRemoteSocketAddress() + " : " + get);
			// 以空格进行分割
			String[] tokens = get.split("\\s+");
			// 链接的方法(get,post)和版本
			String method = tokens[0];
			String version = "";
			
			// 获取头请求中的各个字段
			if("GET".equals(method)){
				String fileName = tokens[1];
				if (fileName.endsWith("/")) fileName += indexFileName;
				String contentType = URLConnection.getFileNameMap().getContentTypeFor(fileName);
				if (tokens.length > 2){
					version = tokens[2];
				}
				
				File theFile = new File(rootDirector, fileName.substring(1, fileName.length()));
				
				// 检测这个文件是否刻度
				if(theFile.canRead() 
						// 不要让客户端读取超出根文档之外
						&& theFile.getCanonicalPath().startsWith(root)){
					byte[] theData = Files.readAllBytes(theFile.toPath());
					if (version.startsWith("HTTP/")){		// 如果是HTTP请求，发送一个首部
						sendHeader(out, "HTTP/1.0 200 OK", contentType, theData.length);
					}
					
					// 发送文件，这可能是一个图片或者其他二进制数据
					// 所以要使用底层流，而不是writer
					raw.write(theData);
					raw.flush();
				}else {// 如果无法找到文件， 暂时没做处理
					String body = "";
					out.write(body);
					out.flush();
				}
			}else {// 使用的方法不是GET方法，暂时没做处理
				String body = "";
				out.write(body);
				out.flush();
			}
		} catch (IOException e) {
			logger.log(Level.WARNING, "Error talking to " + connection.getRemoteSocketAddress(), e);
		}finally{ // 客户的链接一定关闭
			try {
				connection.close();
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * 处理头部请求
	 * @param out 输出流
	 * @param responseCode 返回的头部第一行
	 * @param contentType 返回的文件类型
	 * @param length 文本的长度
	 * @throws IOException 
	 */
	private void sendHeader(Writer out, String responseCode, String contentType, int length) throws IOException{
		out.write(responseCode + "\r\n");
		Date now = new Date();
		out.write("Date: " + now + "\r\n");
		out.write("Server: JHTTP 2.0 " + "\r\n");
		out.write("Content-length: " + length + "\r\n");
		out.write("Content-type: " + contentType + "\r\n\r\n");
		out.flush();
	}

}
