package com.lzd.demoisdemo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * 编写一些不记得的使用类
 * @date 2016年8月4日
 * @author lzd
 *
 */
public class Demo {

	private final static Logger log = Logger.getLogger(Demo.class.getName());
	
	
	@Test
	public void systemContent() throws IOException{
		String bulidDir = StaticPropertiesLoad.getUrlPropertis();
		System.out.println(bulidDir);
		Object value = StaticPropertiesLoad.getValue("url1");
		System.out.println(value);
		
		URL url = new URL((String) value);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setReadTimeout(1000 * 20);
		connection.addRequestProperty("charset", "gb2312");
		
		
		connection.connect();
		String contentType = connection.getContentType();
		System.out.println(contentType);
		for (int i = 0; i <20; i++) {
			String key = connection.getHeaderFieldKey(i);
			String value2 = connection.getHeaderField(i);
			System.out.println(key + " : " + value2);
		}
		InputStream in = connection.getInputStream();
		Reader r = new InputStreamReader(in);
		while(r.read() != -1){
			System.out.print((char) r.read());
		}
	}
	
	
	/**
	 * 获取页面的状态码
	 * 
	 * @author 刘泽栋 2016年8月26日 下午6:49:35
	 * @throws IOException 
	 */
	@Test
	public void testTenv() throws IOException{
		URL url = new URL("https://antx11.answern.com/com.isoftstone.iics.www/pay/return");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setReadTimeout(4000); 	// 设置读取时间
		connection.setConnectTimeout(4000);	// 设置超时时间
		int responseCode = connection.getResponseCode();
		System.out.println(responseCode);
		
		
		
	}
	
	@Test
	public void testStringBuffer(){
		StringBuffer sb = new StringBuffer();
		/*sb.insert(0, "刘泽栋", sb.length(), "刘泽栋".length());
		sb.insert(0, "张学友", sb.length(), "张学友".length());
		sb.insert(0, "lzd", sb.length(), "lzd".length());
		sb.insert(0, "刘华", sb.length(), "刘华".length());*/
		sb.append("1").append(",")
		.append("2").append(",")
		.append("3").append(",")
		.append("4").append(",")
		.append("5").append(",");
		
		sb.delete(sb.length() - 1, sb.length());
		sb.delete(sb.indexOf(","), sb.length());
		
		System.out.println(sb);
	}
	
	/**
	 * 多请求
	 * 
	 * @author 刘泽栋 2016年8月4日 下午3:48:17
	 */
	@Test
	public void moreConnection(){
		String url = "http://localhost:2222";
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			Reader r = new InputStreamReader(new BufferedInputStream(uc.getInputStream()), "UTF-8");
			
			StringBuffer response = new StringBuffer();
			while(true){
				int c;
				if((c = r.read()) != -1){
					response.append((char) c);
				}else {
					break;
				}
			}
			log.info(response.toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	
}
