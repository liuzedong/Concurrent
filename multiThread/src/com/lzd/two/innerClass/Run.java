package com.lzd.two.innerClass;

import com.lzd.two.innerClass.PublicClass.PrivateClass;

/**
 * 运行内部类
 * @date 2016年6月2日
 * @author lzd
 *
 */
public class Run {

	public static void main(String[] args) {
		PublicClass publicclass = new PublicClass();
		publicclass.setUsername("usernameValue");
		publicclass.setPassword("passwordValue");
		// 打印非外部类的参数
		System.out.println(publicclass.getUsername() + " " + publicclass.getPassword());
		
		
		// 必须使用下面的形式，进行调用
		PrivateClass privateClass = publicclass.new PrivateClass();
		privateClass.setAge("ageValue");
		privateClass.setAddress("addressValue");
		System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
	}
}
