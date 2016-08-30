package com.lzd.httpclient;

import java.util.HashSet;
import java.util.Set;

/**
 * 存储已访问的URL
 * 存储待访问的URL
 * @date 2016年8月29日
 * @author lzd
 *
 */
public class URLLinkQueue {
	
	// 已访问URL 集合
	@SuppressWarnings("rawtypes")
	private static Set visitedUrl = new HashSet();
	// 待访问URL 集合
	private static URLQueue unvisitedUrl = new URLQueue();
	
	
	// 获取URL 队列
	public static URLQueue getUnvisitedUrl(){
		return unvisitedUrl;
	}
	
	// 添加到访问过的URL中
	@SuppressWarnings("unchecked")
	public static void addVisitedUrl(String url){
		visitedUrl.add(url);
	}
	
	// 移除访问过的URL 
	public static void removeVisitedUrl(String url){
		visitedUrl.remove(url);
	}
	
	// 未访问的URL 出队
	public static Object unVisitedUrlDeQueue(){
		return unvisitedUrl.deQueue();
	}
	
	// 保证每个URL 只被访问一次
	public static void addUnvisitedUrl(String url){
		// 不为空，并且，也不在已访问和待访问的队列中
		if (url != null && !url.trim().equals("") && !visitedUrl.contains(url) && !unvisitedUrl.contains(url)){
			unvisitedUrl.enQueue(url);
		}
	}
	
	// 获得已经访问的URL 数目
	public static int getVisitedUrlNum() {
		return visitedUrl.size();
	}
	
	// 判断未访问的URL 队列中是否为空
	public static boolean unVisitedUrlIsEmpty() {
		return unvisitedUrl.isQueueEmpty();
	}
}
