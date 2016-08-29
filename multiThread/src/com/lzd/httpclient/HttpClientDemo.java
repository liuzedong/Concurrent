package com.lzd.httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

/**
 * 简单是使用HttpClient 获取页面
 * @date 2016年8月29日
 * @author lzd
 *
 */
public class HttpClientDemo {
	
	/**
	 * 使用HttpClient 使用get请求
	 * 
	 * @author 刘泽栋 2016年8月29日 上午10:38:24
	 * @throws IOException 
	 * @throws HttpException 
	 */
	@Test
	public void httpClientGetUrl() throws HttpException, IOException{
		// 创建一个客户端，相当于打开一个浏览器
		HttpClient httpClient = new HttpClient();
		// 创建一个get方法，类似与，在浏览器中输入一个地址
		GetMethod getMethod = new GetMethod("http://www.jb51.com");
		// 回车，然后获取相应码
		int responseStatus = httpClient.executeMethod(getMethod);
		System.out.println("返回状态码：" + responseStatus);
		
		// 获取返回的更多东西，比如head，cookies等
		System.out.println("返回信息：" + getMethod.getResponseBodyAsString());
		
		// 最后记得，释放连接
		getMethod.releaseConnection();
		
	}

	/**
	 * 使用Poset 请求，获取网页内容
	 * https://passport.jd.com/new/login.aspx
	 * @author 刘泽栋 2016年8月29日 上午10:55:05
	 * @throws IOException 
	 * @throws HttpException 
	 */
	@Test
	public void httpClientPostUrl() throws HttpException, IOException{
		// 创建一个连接的客户端
		HttpClient httpClient = new HttpClient();
		
		// 创建一个Post请求的方法
		PostMethod postMethod = new PostMethod("https://passport.jd.com/new/login.aspx");
		
		// 使用数组来传递参数
		NameValuePair[] postData = new NameValuePair[2];
		
		// 设置参数
		postData[0] = new NameValuePair("loginname", "111111@qq.com");	// 关键字
		postData[1] = new NameValuePair("nloginpwd", "111111");	// 页数
		postMethod.addParameters(postData);
		
		// 回车，获得相应码
		int responseStatusCode = httpClient.executeMethod(postMethod);
		System.out.println("返回状态码：" + responseStatusCode);
		
		// 打印返回的内容
		System.out.println("返回内容：" + postMethod.getResponseBodyAsString());
		
		// 释放连接
		postMethod.releaseConnection();
		
	}
	
}
