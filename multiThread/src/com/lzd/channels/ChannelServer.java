package com.lzd.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 使用通道的server
 * 
 * @date 2016年8月16日
 * @author lzd
 * 
 */
public class ChannelServer {

	public static int DEFUALT_PORT = 2222;

	public static void main(String[] args) {
		int port;

		try {
			port = Integer.parseInt(args[0]);
		} catch (RuntimeException ex) {
			port = DEFUALT_PORT;
		}
		System.out.println("Listening for connections on  port " + port);

		// 旋转把字节，装进byte数组中
		byte[] rotation = new byte[95 * 2];
		for (byte i = ' '; i <= '~'; i++) {
			rotation[i - ' '] = i;
			rotation[i + 95 - ' '] = i;
		}

		ServerSocketChannel serverChannel;
		Selector selector = null;
		try {
			serverChannel = ServerSocketChannel.open();
			ServerSocket ss = serverChannel.socket();
			InetSocketAddress address = new InetSocketAddress(port);
			ss.bind(address);
			// 非阻塞模式
			serverChannel.configureBlocking(false);
			selector = Selector.open();
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 循环连接
		while (true) {
			try {
				selector.select();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}

		Set<SelectionKey> readKeys = selector.selectedKeys();
		Iterator<SelectionKey> iterator = readKeys.iterator();
		while (iterator.hasNext()) {
			SelectionKey key = iterator.next();
			iterator.remove();

			// 如果是连接
			try {
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel client = server.accept();
					System.out.println("Accept connection from " + client);
					client.configureBlocking(false);
					SelectionKey key2 = client.register(selector, SelectionKey.OP_WRITE);
					// 拼装字符我返回给客户端
					ByteBuffer buffer = ByteBuffer.allocate(74);
					buffer.put(rotation, 0, 72);
					buffer.put((byte) '\r');
					buffer.put((byte) '\n');
					buffer.flip();
					key2.attach(buffer);
				} else if (key.isWritable()){
					SocketChannel client = (SocketChannel) key.channel();
					ByteBuffer buffer = (ByteBuffer) key.attachment();
					if (!buffer.hasRemaining()){
						// 用下一行重新填充缓冲区
						buffer.rewind();
						// 得到上一行的字符
						int first = buffer.get();
						// 准备改变缓存区的数据
						buffer.rewind();
						// 寻找rotation中新的首字符位置
						int position = first - ' ' + 1;
						// 将数据充rotation复制到缓冲区中
						buffer.put(rotation, position, 72);
						// 再缓冲区末尾存储一个分行符
						buffer.put((byte) '\r');
						buffer.put((byte) '\n');
						// 准备缓冲区进行写入
						buffer.flip();
					}
					client.write(buffer);
				}
			} catch (IOException e) {
				key.cancel();
				try {
					key.channel().close();
				} catch (IOException e1) {
					e1.printStackTrace();
				};
			}
		}
	}
}
