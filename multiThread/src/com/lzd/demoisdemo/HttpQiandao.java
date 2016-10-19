package com.lzd.demoisdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpQiandao {
	
	public static void main(String[] args) throws Exception {
//		clientGet();
		Cookie[] cookies = clientPost();
//		clientPostQiandao(cookies);
//		md5Code();
//		getStringLength();
//		clientPostFull();
	}
	
	
	// 简单的post请求，进行签到
	public static void clientPostFull(){
		String url = "http://www.18bg.com//check/signin";
		
		HttpClient client = new HttpClient();
		
		PostMethod post = new PostMethod(url);
		
		// 封装签到所使用到的参数
		NameValuePair[] parameters = {new NameValuePair("isWeb", "true"), 
				new NameValuePair("auth", "authentication D3F90A2BC949274C959B9B9BCFBF7299")};
		post.addParameters(parameters);
		
		int status = 0;
		try {
			status = client.executeMethod(post);
		} catch (Exception e) {
		}
		
		// 打印返回状态和返回结果
		System.out.println("返回状态：" + status);
		
		LineNumberReader lnr  = null;
		try {
			lnr = new LineNumberReader(new InputStreamReader(post.getResponseBodyAsStream()));
			while (lnr.ready()){
				System.out.println(lnr.readLine());
			}
		} catch (Exception e) {
		}finally {
			if (lnr != null){
				try {
					lnr.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	
	
	// post请求，用来签到的
	public static void clientPostQiandao(Cookie[] cookies) throws Exception{
		// 用来签到的地址
		String url = "http://www.18bg.com//check/signin";
		
		HttpClient client = new HttpClient();
		
		PostMethod post = new PostMethod(url);
		
		// 设置header消息
		post.addRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		post.addRequestHeader("Accept-Encoding", "gzip, deflate");
		post.addRequestHeader("Accept-Language", "en-US,en;q=0.5");
		post.addRequestHeader("Connection", "keep-alive");
//		post.addRequestHeader("Content-Length", "63");
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		post.addRequestHeader("Host", "www.18bg.com");
		post.addRequestHeader("Referer", "http://www.18bg.com/app/");
		post.addRequestHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:48.0) Gecko/20100101 Firefox/48.0");
		post.addRequestHeader("X-Requested-With", "XMLHttpRequest");
		
		// 添加Cookie消息
		
		// 封装签到所使用到的参数
		NameValuePair[] parameters = {new NameValuePair("isWeb", "true"), 
				new NameValuePair("auth", "authentication D3F90A2BC949274C959B9B9BCFBF7299")};
		post.addParameters(parameters);
		
		
		
		int status = client.executeMethod(post);
		client.getState().addCookies(cookies);
		
		// 获得返回的信息
		InputStream in = post.getResponseBodyAsStream();
		LineNumberReader lnr = new LineNumberReader(new InputStreamReader(in));
		
		// 打印返回的状态
		System.out.println("请求返回的状态：" + status);
		
		while (lnr.ready()){
			System.out.println(lnr.readLine());
		}
		
		
		// 打印返回的头信息
		System.out.println("---------------------------打印返回头部消息----------------------------");
		Header[] headers = post.getResponseHeaders();
		for (Header header : headers) {
			System.out.println(header.getName() + " = " + header.getValue());
		}
		
		
	}
	
	
	
	
	// Post 请求, 这个是用来获取Token 代码的
	public static Cookie[] clientPost() throws Exception {
		HttpClient client = new HttpClient();
		
		PostMethod post = new PostMethod("http://www.18bg.com/api/sign/post");
		
		// 输入参数
		NameValuePair[] parameters = {new NameValuePair("LoginInfo", "zdliuc"), 
				new NameValuePair("Password", "8f24e337fc6605f2ddfe50d1a404669b")};
		
		post.addParameters(parameters);
		
		NameValuePair[] parameters2 = post.getParameters();
		for (NameValuePair nameValuePair : parameters2) {
			System.out.println(nameValuePair.getName() + " = " + nameValuePair.getValue());
		}
		
		
		
		client.executeMethod(post);
		
		int status = client.executeMethod(post);
		
		System.out.println("返回的状态：" + status);

		
		// 获得Cookie消息
		Cookie[] cookies = client.getState().getCookies();
		// 打印出cookie消息
		System.out.println("打印Cookie的消息");
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getDomain());
			System.out.println(cookie.getName() + " = " + cookie.getValue());
		}
		
		
		InputStream in = post.getResponseBodyAsStream();
		LineNumberReader r = new LineNumberReader(new InputStreamReader(in));
		while (r.ready()){
			System.out.println(r.readLine());
		}
		
		return cookies;
	}
	
	
	// Get 请求
	public static void clientGet() throws Exception{
		HttpClient client = new HttpClient();
		
		GetMethod get = new GetMethod("http://www.18bg.com/login");
		
		int status = client.executeMethod(get);
		
		System.out.println("返回的状态：" + status);
		
		InputStream in = get.getResponseBodyAsStream();
		LineNumberReader r = new LineNumberReader(new InputStreamReader(in));
		while (r.ready()){
			System.out.println(r.readLine());
		}
	}

	public static void md5Code(){
		String password = "zdliuc";
		
		String md5Password = DigestUtils.md5Hex(password);
		System.out.println(md5Password);
		
	}
	
	public static void getStringLength(){
		String s = "{\"Data\":null,\"Extra\":null,\"IsError\":true,\"Msg\":\"\",\"ErrorCode\":10000}";
		System.out.println(s.length());
	}
	
}
