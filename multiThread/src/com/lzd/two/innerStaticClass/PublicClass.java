package com.lzd.two.innerStaticClass;
/**
 * 内置类和静态内置类
 * @date 2016年6月2日
 * @author lzd
 *
 */
public class PublicClass {

	private static String username;
	private static String password;
	
	// 内部类
	static class PrivateClass{
		private String age;
		private String address;
		
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void printPublicProperty(){
			System.out.println(username + " " + password);
		}
	}
	
	
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
	
	
	
}
