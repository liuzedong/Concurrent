package com.lzd.internet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 显示所有的首部信息
 * @date 2016年7月29日
 * @author lzd
 *
 */
public class AllHeaders {
	
	private static final String url = "http://www.baidu.com";
	
	public static void main(String[] args) {
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			
			for (int i = 1; ; i++) {
				String header = uc.getHeaderField(i);
				if(header == null) break;
				System.out.println(uc.getHeaderFieldKey(i) + " : " + header);
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
