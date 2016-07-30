package com.lzd.internet;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

/**
 * 使用URLEncoder对Java中连续的名-值对编码
 * @date 2016年7月28日
 * @author lzd
 *
 */
public class QueryString {
	
	private StringBuilder query = new StringBuilder();
	
	public QueryString(){}
	
	public synchronized void add(String name, String value){
		query.append("&");
		encode(name, value);
	}

	private synchronized void encode(String name, String value){
		try {
			query.append(URLEncoder.encode(name, "UTF-8"));
			query.append("=");
			query.append(URLEncoder.encode(value, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized String getQuery(){
		String queryString = query.substring(1);
		return queryString;
	}

	@Override
	public String toString() {
		return getQuery();
	}
	
	
	@Test
	public void URLtest(){
		QueryString qs = new QueryString();
		qs.add("name", "liudong");
		qs.add("sex", "女");
		String url = "http://www.liuzedong.com?";
		System.out.println(url + qs.toString());
	}
}
