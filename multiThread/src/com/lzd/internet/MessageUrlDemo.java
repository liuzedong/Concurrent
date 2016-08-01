package com.lzd.internet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import sun.misc.BASE64Encoder;

/**
 * 短信接口使用示例
 * @date 2016年8月1日
 * @author lzd
 *
 */
public class MessageUrlDemo {
	
	public static final String username = "api";
	public static final String password = "key-官网密钥";
	
	public static void main(String[] args) {
		try {
			URL u = new URL("http://sms-api.luosimao.com/v1/send.json");
			
			
			// 添加密码认证
			StringBuffer userAndPassword = new StringBuffer();
			userAndPassword.append("Basic ");
			String uap = username + ":" + password;
			userAndPassword.append(new BASE64Encoder().encode(uap.getBytes()));
			
			System.out.println(userAndPassword.toString());
			
			QueryString q = new QueryString();
			q.add("mobile", "手机号");
			q.add("message", "技术标题：我是栋哥"+"\r\n" +"技术内容：我是栋栋虾，多些一点，好好上课"
					+ "，认证听讲，知道不，别东张西望的。说的就是你【栋栋技术社】");
			
			
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			// 写入认证信息
			uc.addRequestProperty("Authorization", userAndPassword.toString());
			
			System.out.println(q.toString());
			
			// 写入值
			uc.setDoOutput(true);
			try(Writer out = new OutputStreamWriter(uc.getOutputStream(), "UTF-8");){
				out.write(q.toString());
				out.flush();
			}
			
			
			// 获取返回值
			try(Reader r = new InputStreamReader(uc.getInputStream(), "UTF-8");){
				int c;
				while((c = r.read()) != -1){
					System.out.print((char) c);
				}
				System.out.println();
				System.out.println(uc.getResponseCode());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
