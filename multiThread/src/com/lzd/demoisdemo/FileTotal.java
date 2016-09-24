package com.lzd.demoisdemo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * 统计目录的大小
 * @date 2016年9月22日
 * @author lzd
 *
 */
public class FileTotal {

	public static void main(String[] args) throws IOException {
		File f = new File("/home/liuzedong/eparted/android-sdk-linux");
//		File f = new File("/");
		
		long free = f.getFreeSpace();
		long totalSpace = f.getTotalSpace();
		long usableSpace = f.getUsableSpace();
		System.out.println("可用：" + free / (1000 * 1000 * 1000) + "G" );
		System.out.println("容量：" + totalSpace / (1000 * 1000 * 1000) + "G");
		System.out.println("已用：" + usableSpace / (1000 * 1000 * 1000) + "G");
		
		System.out.println( free + "------" + usableSpace);
		
		Runtime runtime = Runtime.getRuntime();
		InputStream in = null;
		String[] command = {"df -h", "du -h /"};
		for (String com : command) {
			Process p = runtime.exec(com);
			 in = p.getInputStream();
			 LineNumberReader input = new LineNumberReader(new InputStreamReader(in));
			 
			 while(input.readLine() != null){
				 System.out.println(input.readLine());
			 }
			 
		}
		in.close();
	}
	
	
}
