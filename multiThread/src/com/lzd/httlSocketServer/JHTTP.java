package com.lzd.httlSocketServer;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 功能比较完善的HTTP服务器，会读取当前的文件系统
 * 并且返回当前服务器的目录，这个是启动类
 * @date 2016年8月6日
 * @author lzd
 */
public class JHTTP {
	
	// 获取这个类的全名称com.lzd.httlSocketServer.JHTTP
	private static final Logger logger = Logger.getLogger(JHTTP.class.getCanonicalName());
	
	// 创建线程的数量
	private static final int NUM_THREAD = 50;
	// 返回的首页
	private static final String INDEX_FILE = "index.html";
		
	// 根目录
	private final File rootDirectory;
	// 开启访问的接口
	private final int port;
	
	
	
	public JHTTP(File rootDirector, int port) throws IOException{
		// 如果，这个根文件的目录是个空的，那么就抛出异常，因为你没有根目录
		if(! rootDirector.isDirectory()) throw new IOException(rootDirector + "does not exist as a director");
		
		this.rootDirectory = rootDirector;
		this.port = port;
	}
	
	
	/**
	 * 主要的处理方法，每个链接进来就创建一个线程进行单独的处理，
	 * 使用线程池，将线程维护在50个，不然会内存溢出的
	 */
	public void start(){
		ExecutorService pool = Executors.newFixedThreadPool(NUM_THREAD);
		try(ServerSocket server = new ServerSocket(port)){
			logger.info("链接的端口：" + server.getLocalPort() );
			logger.info("使用的根目录：" + this.rootDirectory);
			
			while(true){
				Socket request = server.accept();
				//  每来一个链接创建一个线程类，来处理请求
				Runnable r = new RequestProcessor(rootDirectory, INDEX_FILE, request);
				pool.submit(r);
			}
		} catch (IOException e) {
			logger.log(Level.WARNING, "Error accepting", e);
		}
	}
	
	

	// 启动这个 服务器
	public static void main(String[] args) {
		// 得到根目录
		File docroot;
		try{
			docroot = new File("/home/liuzedong");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Usage : java JHTTP docroot port");
			return;
		}
		
		// 设置要监听的端口
		int  port;
		try{
			port = 2222;
			if (port < -1 || port > 65535) port = 80;
		}catch(RuntimeException e){
			port = 80;
		}
		
		// 启动服务器
		try{
			JHTTP webserver = new JHTTP(docroot, port);
			webserver.start();
		}catch(IOException e){
			logger.log(Level.SEVERE, "服务器启动失败啦。。。", e);
		}
		
		
		
	}

}
