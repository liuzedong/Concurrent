package com.lzd.lang;

import java.io.IOException;

/**
 * Runtime 调用其他进程的案例
 * @date 2016年9月29日
 * @author lzd
 *
 */
public class RuntimeIsExceDemo {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		
		// 调用其他进行
		Process p = runtime.exec("gftp");
		
		int waitFor = p.waitFor();
		System.out.println("等待：" + waitFor);
		
		
		
		int exitValue = p.exitValue();
		System.out.println(exitValue);
		
		
	}

}
