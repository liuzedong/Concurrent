package com.lzd.httpclient;

import java.util.HashSet;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 * 解析HTML 的工具类
 * @date 2016年8月29日
 * @author lzd
 *
 */
public class HtmlParserTool {

	/**
	 * 获取一个网络连接，Filter用来过滤连接
	 * @param url
	 * @param filter
	 * @return
	 * @author 刘泽栋 2016年8月29日 下午5:58:13
	 */
	public static Set<String> extracLinks(String url, LinkFilter filter){
		Set<String> links = new HashSet<String>();
		try {
			Parser parser = new Parser(url);
			parser.setEncoding("gb2312");
			// 过滤<frame>标签filter， 用来提取frame标签中set属性
			@SuppressWarnings("serial")
			NodeFilter frameFilter = new NodeFilter() {
				@Override
				public boolean accept(Node node) {
					if (node.getText().startsWith("frame src=")){
						return true;
					}else {
						return false;
					}
				}
			};

			// orFilter来设置过滤<a>标签和frame标签
			OrFilter linkFilter = new OrFilter(new NodeClassFilter(LinkTag.class), frameFilter);
			
			// 得到所有经过过滤的标签
			NodeList list = parser.extractAllNodesThatMatch(linkFilter);
			for (int i = 0; i < list.size(); i++) {
				Node tag = list.elementAt(i);
				if (tag instanceof LinkTag){	// <a>标签
					LinkTag link = (LinkTag) tag;
					String linkUrl = link.getLink();	// URL
					if (filter.accept(linkUrl)){
						links.add(linkUrl);
					} else {	// <frame> 标签
						// 提取frame里 src 属性得到链接，如<frame src="test.html">
						/*String frame = tag.getText();
						int start = frame.indexOf("href=");
						frame = frame.substring(start);
						int end = frame.indexOf(" ");
						if (end == -1){
							end = frame.indexOf(">");
						}
						String frameUrl = frame.substring(5, end - 1);
						if (filter.accept(frameUrl)){
							links.add(frameUrl);
						}*/
					}
				}
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return links;
	}
	
}
