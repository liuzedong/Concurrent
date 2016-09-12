package com.lzd.demoisdemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 定时器的使用案例
 * @date 2016年9月1日
 * @author lzd
 *
 */
public class TimerDemo {

	private static LinkedList<String> list = new LinkedList<String>();
	
	
	static {
		list.add("刘德华1");
		list.add("刘德华2");
		list.add("刘德华3");
		list.add("刘德华4");
	}
	
	public static void main(String[] args) throws InterruptedException {
		/*Timer t = new Timer("我是一个定时器");
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("---刘泽栋开始运行---");
				try {
					if (list != null && list.size() > 0){
						String first = list.pop();
						System.out.println(first + "拿出来啦。。。。");
					}
					Thread.sleep(1000 * 10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("×××刘泽栋结束运行×××");
			}
		}, 0, 1000 * 3);
		*/
		
		/*Random s = new Random();
		while(true){
			Date d = new Date();
			System.out.println(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(d)
					+ s.nextInt(10000));
			Thread.sleep(1000 * 1);
		}*/
		
		List<User> list = new ArrayList<User>();
		User u1 = new User();
		u1.setUsername("你好");
		u1.setPassword("123");
		
		User u2 = new User();
		u2.setUsername("张学友");
		u2.setPassword("123");
		User u3 = new User();
		u3.setUsername("刘东");
		u3.setPassword("123");
		User u4 = new User();
		u4.setUsername("李连杰");
		u4.setPassword("123");
		
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		
		for (User user : list) {
			String username = user.getUsername();
			if ("刘东".equals(username)){
				list.remove(user);
			}
		}
		System.out.println(list);
		
		
		String abc = "abcde";
		
		String[] split = abc.split("张");
		System.out.println(split[0]);
		
		
	}
	
}
class User {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return username + "  :  " + password;
	}
}