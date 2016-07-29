package com.lzd.internet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 使用正确的字符集，下载一个web网页
 * @date 2016年7月29日
 * @author lzd
 *
 */
public class EncodingAwareSourceViewer {
	
	private static final String url = "http://www.51cto.com";
	
	public static void main(String[] args){
		
		// 设置默认字符集编码
		String encoding = "gbk";
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			// 获得 该网站要求的字符集
			String contentType = uc.getContentType();
			int encodingStart = contentType.indexOf("charset=");
			if(encodingStart != -1){
				encoding = contentType.substring(encodingStart + 8);
			}
			InputStream in = new BufferedInputStream(uc.getInputStream());
			Reader r = new InputStreamReader(in, encoding);
			int c;
			while((c = r.read()) != -1){
				System.out.print((char)c);
			}
			r.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
