package com.lzd.httpclient;

import java.util.Set;

/**
 * 宽度爬虫的主程序
 * @date 2016年8月29日
 * @author lzd
 *
 */
public class MyCrawler {
	
	/**
	 * 使用种子初始化 URL 队列
	 * @param seeds
	 * @author 刘泽栋 2016年8月29日 下午6:26:40
	 */
	private void initCrawlerWithSeeds(String[] seeds){
		for (int i = 0; i < seeds.length; i++) {
			URLLinkQueue.addUnvisitedUrl(seeds[i]);
		}
	}
	
	/**
	 * 抓取过程
	 * @param seeds
	 * @author 刘泽栋 2016年8月29日 下午6:27:38
	 */
	public void crawling(String[] seeds){
		// 定义过滤器，提取http://www.jb51.com 开头的连接
		LinkFilter filter = new LinkFilter() {
			@Override
			public boolean accept(String url) {
				if (url.startsWith("http://www.jb51.com"))
					return true;
				else
					return false;
			}
		};
		
		// 初始化URL 队列
		initCrawlerWithSeeds(seeds);
		// 循环条件：待抓取的连接不空，且抓取页面超过20
		while(!URLLinkQueue.unVisitedUrlIsEmpty() && URLLinkQueue.getVisitedUrlNum() <= 20){
			// 队头URL 出队列
			String visitUrl = (String) URLLinkQueue.unVisitedUrlDeQueue();
			if (visitUrl == null){
				continue;
			}
			DownLoadFile downLoad = new DownLoadFile();
			// 下载网页
			downLoad.downLoadFile(visitUrl);
			// 该URL 放入已访问的URL 中
			URLLinkQueue.addVisitedUrl(visitUrl);
			// 提取下载网页中的URL 
			Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter);
			for (String link : links) {
				URLLinkQueue.addUnvisitedUrl(link);
			}
		}
	}
	
	/**
	 * 方法的入口
	 * @param args
	 * @author 刘泽栋 2016年8月29日 下午7:04:08
	 */
	public static void main(String[] args) {
		MyCrawler crawler = new MyCrawler();
		crawler.crawling(new String[]{"http://www.jb51.com"});
	}
}
