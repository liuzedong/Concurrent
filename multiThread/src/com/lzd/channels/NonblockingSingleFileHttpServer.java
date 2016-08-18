package com.lzd.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

/**
 * 提供一个单文件的非阻塞HTTP服务器
 * @date 2016年8月18日
 * @author lzd
 *
 */
public class NonblockingSingleFileHttpServer {
	
	private ByteBuffer contentBuffer;
	private int port = 80;
	
	public NonblockingSingleFileHttpServer(ByteBuffer data, String encoding, String MIMEType, int port){
		this.port = port;
		// 返回的数据
		String header = "HTTP/1.0 200 OK\r\n"
				+ "Server: NonblockingSingleFileHttpServer\r\n"
				+ "Content-length: " + data.limit() + "\r\n"
				+ "Content-type: " + MIMEType + ";charset=utf-8\r\n\r\n";
		byte[] headerData = header.getBytes(Charset.forName("US-ASCII"));
		ByteBuffer buffer = ByteBuffer.allocate(data.limit() + headerData.length);
		buffer.put(headerData);
		buffer.put(data);
		buffer.flip();
		this.contentBuffer = buffer;
	}

	public void run() throws IOException{
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		ServerSocket serverSocket = serverChannel.socket();
		Selector selector = Selector.open();
		InetSocketAddress address = new InetSocketAddress(port);
		serverSocket.bind(address);
		serverChannel.configureBlocking(false);
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		// 链接
		while(true){
			selector.select();
			Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
			while(keys.hasNext()){
				SelectionKey key = keys.next();
				keys.remove();
				
				if(key.isAcceptable()){
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel channel = server.accept();
					channel.configureBlocking(false);
					channel.register(selector, SelectionKey.OP_READ);
				} else if (key.isWritable()){
					SocketChannel channel = (SocketChannel) key.channel();
					ByteBuffer buffer = (ByteBuffer) key.attachment();
					if(buffer.hasRemaining()){
						channel.write(buffer);
					} else { // 结束工作
						channel.close();
					}
				} else if (key.isReadable()){
					// 不用费力的解析HTTP首部，只需要读取
					SocketChannel channel = (SocketChannel) key.channel();
					ByteBuffer buffer = ByteBuffer.allocate(4096);
					channel.read(buffer);
					// 将通道切换到只读模式
					key.interestOps(SelectionKey.OP_WRITE);
					key.attach(contentBuffer.duplicate());
				}
			}
		}
	}
	
	public static void main(String[] args){
		if(args.length == 0){
			System.out.println("Usage: Java NonblockingSingleFileHttpServer file port encoding ");
			return ;
		}
		
		try {
			String contentType = URLConnection.getFileNameMap().getContentTypeFor(args[0]);
			Path file = FileSystems.getDefault().getPath(args[0]);
			byte[] data = Files.readAllBytes(file);
			ByteBuffer input = ByteBuffer.wrap(data);
			
			// 设置要监听的端口
			int port;
			try {
				port = Integer.parseInt(args[1]);
			} catch (RuntimeException e) {
				port = 1919;
			}
			
			String encoding = "UTF-8";
			NonblockingSingleFileHttpServer server = new NonblockingSingleFileHttpServer(input, encoding, contentType, port);
			server.run();
		} catch (Exception e) {
		}
	}
	
}
