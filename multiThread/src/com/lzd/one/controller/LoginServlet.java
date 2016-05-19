package com.lzd.one.controller;
/**
 * 本类，模拟一个Servlet组件，非线程安全和线程安全的示例
 * 非线程安全的时候，b的密码是aa，这是不对的
 * @date 2016年5月19日
 * @author lzd
 *
 */
public class LoginServlet {
	private static String usernameRef;
	private static String passwordRef;
	
	// 非线程安全的,打开注解，进行测试
	// 处理用户登录的，用户名和密码
	/*public static void doPost(String username, String password){
		try{
			usernameRef = username;
			if(username.equals("a")){
				Thread.sleep(1000);
			}
			passwordRef = password;
			System.out.println("username = " + usernameRef + ",password = " + passwordRef);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	
	// 线程安全的
	synchronized public static void doPost(String username, String password){
		try{
			usernameRef = username;
			if(username.equals("a")){
				Thread.sleep(1000);
			}
			passwordRef = password;
			System.out.println("username = " + usernameRef + ",password = " + passwordRef);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
