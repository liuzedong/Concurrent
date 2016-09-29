package com.lzd.lang;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * 使用ProcessBuilder 来管理其他进程
 * @date 2016年9月29日
 * @author lzd
 *
 */
public class ProcessBuilderDemo {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("pwd", "");
		File outFile = new File("/home/liuzedong/test/result.txt");
//		pb.directory(new File("/home/liuzedong"));
		File directory = pb.directory();
		System.out.println(directory);
		
		pb.redirectOutput(outFile);
		Map<String, String> environment = pb.environment();
		Set<String> keySet = environment.keySet();
		for (String key : keySet) {
			System.out.println(key + ":" + environment.get(key));
		}
		int size = environment.size();
		System.out.println("总共有多少环境变量： " + size);
		
		// 启动程序
		pb.start();
		
	}
	
	
}
