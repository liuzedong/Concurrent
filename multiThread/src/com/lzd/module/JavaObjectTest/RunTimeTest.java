package com.lzd.module.JavaObjectTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 练习Runtime中的方法，看看具体怎么使用
 * @date 2016年7月19日
 * @author lzd
 *
 */
public class RunTimeTest {
	
	private static Runtime rt = null;
	
	public RunTimeTest(){
		rt = Runtime.getRuntime();
	}
	
	public static void main(String[] args) {
		new RunTimeTest();
		getMemory();
//		useCommand();
		
		
	}
	
	
	// 获取当前内存的信息，这个堆的空闲内存，不是系统的内存
	public static void getMemory(){
		// 当前的空闲内存。这个堆的空闲内存，不是系统的内存
		long freeMemory = rt.freeMemory();
		System.out.println("当前剩余的堆内存：" + (freeMemory / 1024 / 1024) + "M");
		
		
		
	}
	
	// 使用当前系统的命令行
	public static void useCommand(){
		// 通过当前Java虚拟机查看当前机器的可用处理器的数目
		int coreNumber = rt.availableProcessors();
		System.out.println("处理器的个数：" + coreNumber);

		try {

			// 会调用，命令行，然后输入，字符串所写的命令
			// Process p = rt.exec("w");
			Process p = rt.exec(new String[] { "pwd", "geany" });
			InputStream inputStream = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					inputStream));

			String line = null;
			StringBuffer s = new StringBuffer();
			while ((line = br.readLine()) != null) {
				s.append(line + "\n");
			}

			System.out.println(s.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
