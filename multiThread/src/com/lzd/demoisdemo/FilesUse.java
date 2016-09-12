package com.lzd.demoisdemo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.util.DateUtil;

/**
 * 对JDK7 对文件的操作
 * @date 2016年9月7日
 * @author lzd
 *
 */
public class FilesUse {
	
	private static final String filePath = "/app/liudong/20160910/policy.txt";
	private static final String filePath2 = "/app/demo/HelloWorld.pdf";
	
	public static void main(String[] args) throws IOException {
		Path path = Paths.get(filePath);
		System.out.println(path.getParent());
		
		
		boolean directory = Files.isDirectory(path.getParent());
		System.out.println(directory);
		
		boolean exists = Files.exists(path);
		System.out.println(exists);
		
		String formatDate = DateUtil.formatDate(new Date(), "yyyyMMdd");
		System.out.println(formatDate);
		if (!directory){
			Files.createDirectories(path.getParent());
		}
		System.out.println(directory);
		
		/*if (!exists){
			Files.createFile(path);
		}
		System.out.println(exists);*/
		

		FileWriter writer = null;
		try {
			writer = new FileWriter(filePath, true);
			writer.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "我三刘泽栋\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
