package com.lzd.internet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 拼接一个完整的URL，可进行查询，get请求
 * @date 2016年7月28日
 * @author lzd
 *
 */
public class DMoz {
	
	public static void main(String[] args) {
		String target = "";
		
		String[] values = new String[]{"我们"};
		
		for (int i = 0; i < values.length; i++) {
			target += values[i] + " ";
		}
		target = target.trim();
		
		QueryString q = new QueryString();
		q.add("s", "10520733385329581432");
		q.add("ie", "uhf-8");
		q.add("q", target);
		// 第几页
		q.add("p", "1");
		
		try {
			URL u = new URL("http://so.jb51.net/cse/search?" + q);
			try(
					InputStream in = new BufferedInputStream(u.openStream());
					){
				InputStreamReader theHTML = new InputStreamReader(in);
				char[] cbuf = new char[1024 * 5];
				while((theHTML.read(cbuf)) != -1){
					System.out.print(new String(cbuf));
				}
			System.out.println("访问地址：" + u);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
