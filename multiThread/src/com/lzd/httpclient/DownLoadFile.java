package com.lzd.httpclient;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * 下载网页文件
 * @date 2016年8月29日
 * @author lzd
 *
 */
public class DownLoadFile {
	
	/**
	 * 根据URL 和网页的类型， 生成需要保存的网页的文件名称，去除URL 中的非文件名字符
	 * @param url url
	 * @param contentType 文件类型
	 * @return
	 * @author 刘泽栋 2016年8月29日 下午2:07:13
	 */
	public String getFileNameByUrl(String url, String contentType){
		// 移除http://
		url = url.substring(7);
		// text/html 类型，起始就是判断字符串中是否包含html， 替换的正则意思：把\ / :* | < > " 这些符号都替换成 _ 
		if (contentType.indexOf("html") != -1){
			url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
			return url;
		} else {	// 其他类型如：application/pdf 类型
			return url.replaceAll("[\\?/:*|<>\"]", "_") + "." + contentType.substring(contentType.lastIndexOf("/") + 1);
		}
	}
	
	/**
	 * 保存网页字节数组到本地文件
	 * @param data 数据
	 * @param filePath 保存文件地址
	 * @author 刘泽栋 2016年8月29日 下午2:24:28
	 */
	private void saveToLocal(byte[] data, String filePath){
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath));
			for (int i = 0; i < data.length; i++) {
				out.write(data[i]);
			}
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 下载URL 指向的网站
	 * @param url
	 * @return
	 * @author 刘泽栋 2016年8月29日 下午2:28:38
	 */
	public String downLoadFile(String url){
		String filePath = null;
		// 1，生成HttpClient 对象并设置参数
		HttpClient httpClient = new HttpClient();
		// 设置链接超时时间
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(1000*5);
		
		// 2，生成GetMethod对象并设置参数
		GetMethod getMethod = new GetMethod(url);
		// 设置get的请求超时时间
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5 * 1000);
		// 设置请求重试
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		
		// 3，执行 HTTP GET 请求
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			// 判断访问的状态嘛
			if (statusCode != HttpStatus.SC_OK){
				System.out.println("Method faild : " + getMethod.getStatusLine());	// 打印状态行
				filePath = null;
			}
			
			// 4，处理 HTTP 响应内容
			byte[] responseBody = getMethod.getResponseBody();	// 读取为字符串的数组
			// 根据网页 url 生成保存时的文件名
			filePath = "/app/demo/www/" + getFileNameByUrl(url, getMethod.getResponseHeader("Content-Type").getValue());
			saveToLocal(responseBody, filePath);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			getMethod.releaseConnection();
		}
		return filePath;
	}
	
}
