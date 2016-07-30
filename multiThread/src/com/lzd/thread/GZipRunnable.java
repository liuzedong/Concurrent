package com.lzd.thread;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 它包含一个字段来标记要压缩的文件，run()方法会压缩这个文件并返回
 * 
 * @date 2016年7月27日
 * @author lzd
 * 
 */
public class GZipRunnable implements Runnable {

	private final File input;

	public GZipRunnable(File input) {
		this.input = input;
	}

	@Override
	public void run() {
		// 不压缩已压缩的文件
		if(!input.getName().endsWith(".gz")){
			File output = new File(input.getParent(), input.getName() + ".gz");
			if(!output.exists()){	// 不覆盖已经存在的文件
				try(
						InputStream in = new BufferedInputStream(new FileInputStream(input));
						OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)));
						){
					int b;
					while ((b = in.read()) != -1) out.write(b);
					out.flush();
				}catch(IOException e){
					System.err.println(e);
				}
			}
			
			
		}
	}

}
