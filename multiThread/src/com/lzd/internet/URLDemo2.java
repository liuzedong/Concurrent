package com.lzd.internet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 电子保单
 * @date 2016年8月3日
 * @author lzd
 *
 */
public class URLDemo2 {
	
	
	public static void main(String[] args) {
		try {
			URL u = new URL("http://127.0.0.1:8080/com.isoftstone.iics.bizsupport.epps/epolicy/create.json");
			Reader in = new InputStreamReader(new FileInputStream("/app/test/jidinghe_msg_EC16070007.xml"), "UTF-8");
			
			StringBuffer buffer = new StringBuffer();
			/*buffer.append("----testsssssss").append("\r\n");
			buffer.append("Content-Disposition: form-data; name=\"xmlFile\"");
			buffer.append("\r\n\r\n");*/
			int c;
			while((c = in.read()) != -1){
				buffer.append((char) c);
			}
			/*buffer.append("\r\n");
			buffer.append("----testsssssss").append("\r\n");*/
			
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			uc.setDoOutput(true);
			uc.addRequestProperty("ContentCharset", "UTF-8");
//			uc.addRequestProperty("text/xml", "UTF-8");
			uc.addRequestProperty("Content-Type", "text/xml;");
			uc.setRequestMethod("POST");
			uc.setReadTimeout(5 * 60 * 1000);
			uc.setConnectTimeout(5 * 60 * 1000);
			uc.setUseCaches(false);
			
			
			Writer out = new OutputStreamWriter(uc.getOutputStream(), "UTF-8");
			
			System.out.println(buffer.toString());
			
			out.write(buffer.toString());
			out.flush();
			
			
			// 获取所有的信息
			String headerField = uc.getHeaderField(0);
			System.out.println(headerField);
			
			uc.connect();
			
			in.close();
			out.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
