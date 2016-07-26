package com.lzd.net.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 * 测试OutputStream类的一些使用示例
 * @date 2016年7月25日
 * @author lzd
 *
 */
public class OutputStreamDemo {
	
	
	/**
	 * 每次发送单个字节，使用的是write(int b)  方法，这样不是特别的有效率
	 * 而且，发送的单个int是ASCII 的转译码
	 * @throws Exception
	 * @author 刘泽栋 2016年7月25日 下午7:30:47
	 */
	@Test
	public void generateCharacters() throws Exception{
		OutputStream os = new FileOutputStream(new File("/app/demo/abc.txt"));
		int firstPrintableCharacter = 33;
		int numberOfPrintableCharacters = 94;
		int numberOfCharatersPerLine =72;
		
		int start = firstPrintableCharacter;
		
		while(true) {
			for(int i=start; i < start + numberOfCharatersPerLine; i++) {
				os.write((
						(i - firstPrintableCharacter) % numberOfPrintableCharacters) 
						+ firstPrintableCharacter
						);
				os.write('\r');  // 回车
				os.write('\n');	// 换行
				start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
			}
		}
	}

	/**
	 * 生成字符，先保存在内存中，等需要的时候，再一次性写出去
	 * 使用write(byte[] b) 或 write(byte[] b, int off, int len) 
	 * @throws Exception
	 * @author 刘泽栋 2016年7月25日 下午7:33:45
	 */
	@Test
	public void generateCharactersToWriteMemory () throws Exception{
		OutputStream os = new FileOutputStream(new File("/app/demo/abc.txt"));
		int firstPrintableCharacter = 33;
		int numberOfPrintableCharacters = 94;
		int numberOfCharatersPerLine =72;
		
		int start = firstPrintableCharacter;
		
		// 内存中需要保存的大小
		byte[] line = new byte[numberOfCharatersPerLine + 2];
		
		while(true) {// 无限循环，进行写数据
			for(int i=start; i < start + numberOfCharatersPerLine; i++) {
				line[i - start] = (byte)((i - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter);
			}
			line[72] = '\r'; // 回车
			line[73] = '\n'; // 换行
			os.write(line);
			
			start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
		}
	}
	
	public void jdk7try() throws Exception{
		try(OutputStream os = new FileOutputStream("/tmp/abc.txt")){
			
		}
	}
	
	
}
