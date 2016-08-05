package com.lzd.httlSocketServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 重定向服务器，所有过来的连接，都将会重定向到一个信息的地址上面
 * @date 2016年8月5日
 * @author lzd
 *
 */
public class RedirectorServer {

	private static final Logger logger = Logger.getLogger("RedirectorServer");
	
	private final int port;
	private final String newSite;
	
	public RedirectorServer(String newSite, int port){
		this.port = port;
		this.newSite = newSite;
	}
	
	public void start(){
		try(ServerSocket server = new ServerSocket(port)){
			logger.info("Redirecting connection on port" + server.getLocalPort() + " to " + newSite);
			
			while(true){
				Socket s = server.accept();
				Thread t = new RedirectThread(s);
				t.start();
			}
		} catch (IOException e) {
			logger.warning("Could not start server.");
		}
	}
	
	private class RedirectThread extends Thread{

		private final Socket connection;
		
		public RedirectThread(Socket s){
			this.connection = s;
		}
		
		@Override
		public void run() {
			try(
					Writer out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "US-ASCII"));
					Reader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					){
				// 只读取第一行，这里有我们需要的内容（其实好像没用的）
				StringBuilder request = new StringBuilder(80);
				while(true){
					int c = in.read();
					if(c == '\r' || c == '\n' || c == -1) break;
					request.append((char) c);
				}
				
				String get = request.toString();
				String[] pieces = get.split("\\w*");
				String theFile = pieces[1];
				
				// 如果是HTTP/1.0或者以后的版本，则发送一个MIME首部
				if(get.indexOf("HTTP") != -1){
					out.write("HTTP/1.0 302 FOUND\r\n");
					Date now = new Date();
					out.write("Date: " + now + "\r\n");
					out.write("Server: Redirector 1.1\r\n");
					out.write("Location: " + newSite + theFile + "\r\n");
					out.write("Content-type: text/html\r\n\r\n");
					out.flush();
				}

				// 并不是所有浏览器都支持重定向的，所以我们需要
				// 生成HTML指出文档转移的地方
				out.write("<HTML><HEAD><TITLE>Document moved</TITLE></HEAD>\r\n");
				out.write("<BODY><H1>Document moved</H1>\r\n");
				out.write("The document " + theFile + " has move to\r\n<A HREF=\"" + newSite + theFile + "\">"
						+ newSite + theFile
						+ "</A>.\r\n Please update your bookmarks<P>");
				out.write("</BODY></HTML>\r\n");
				out.flush();
				
				logger.log(Level.INFO, "Redirected" +connection.getRemoteSocketAddress());
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (IOException e) {}
			}
		}
	}
	
	/**
	 * 主启动程序
	 * @param args
	 * @author 刘泽栋 2016年8月5日 下午5:18:31
	 */
	public static void main(String[] args) {
		int thePort = 2222;
		String theSite = "http://www.baidu.com";
		
		RedirectorServer server = new RedirectorServer(theSite, thePort);
		server.start();
		
	}
}
