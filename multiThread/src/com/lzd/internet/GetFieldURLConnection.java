package com.lzd.internet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 获取URLConnetction 中的get参数
 * @date 2016年7月29日
 * @author lzd
 *
 */
public class GetFieldURLConnection {
	
	private static final String url = "http://qdcu02.baidupcs.com/file/f074675cb9c6a925b25368398c64253c?bkt=p-41809a0fe70f77cebbb7045d83e6f491&fid=3106415542-250528-994761096271193&time=1469754770&sign=FDTAXGERLBH-DCb740ccc5511e5e8fedcff06b081203-Gl6bwmVWJQw5mew63rsi5IigWII%3D&to=qdvb&fm=Qin,B,U,nc&sta_dx=755&sta_cs=367&sta_ft=rar&sta_ct=7&fm2=Qingdao,B,U,nc&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=1400f074675cb9c6a925b25368398c64253c983030e200002f3231d8&sl=75759692&expires=8h&rt=pr&r=179354683&mlogid=4879396931080611176&vuk=3106415542&vbdid=1956180142&fin=%E7%AC%AC1%E5%86%8Cmp3.rar&fn=%E7%AC%AC1%E5%86%8Cmp3.rar&slt=pm&uta=0&rtype=0&iv=1&isw=0&dp-logid=4879396931080611176&dp-callid=0.1.1";
	
	public static void main(String[] args) {
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			
			boolean allowUserInteraction = uc.getAllowUserInteraction();
			System.out.println("UserInteraction 字段的值 : " + allowUserInteraction);
			
			int connectTimeout = uc.getConnectTimeout();
			System.out.println("连接超时时间 : " + connectTimeout);
			
			String contentEncoding = uc.getContentEncoding();
			System.out.println("content-encoding 头字段的值 : " + contentEncoding);
			
			int contentLength = uc.getContentLength();
			System.out.println("content-length 头字段的值 : " + contentLength /1024/1024 + "M");
			
			String contentType = uc.getContentType();
			System.out.println("content-type 头字段的值 : " + contentType);
			
			long date = uc.getDate();
			System.out.println("date 头字段的值 : " + date);
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
