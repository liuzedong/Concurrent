package com.lzd.thread;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用户接口调用类，调用GZipRunnable类
 * @date 2016年7月27日
 * @author lzd
 *
 */
public class GZipAllFiles {
	
	// 创建线程池 个数
	public final static int THREAD_COUNT = 4;
	
	public static void main(String[] args) {
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
		
		for (String filename : args) {
			File f = new File(filename);
			if(f.exists()){	// 文件或者目录是否存在
				if(f.isDirectory()){  // 是否是目录
					File[] files = f.listFiles(); // 获取目录下的所有文件
					for (int i = 0; i < files.length; i++) {
						if(!files[i].isDirectory()){	// 不压缩目录
							Runnable task = new GZipRunnable(files[i]);
							pool.submit(task);
						}
					}
				} else {
					Runnable task = new GZipRunnable(f);
					pool.submit(task);
				}
			} else {
				System.err.println(f.getAbsolutePath() + "：此路径的目录或者文件不存在");
			}
		}
		pool.shutdown();
	}
}
