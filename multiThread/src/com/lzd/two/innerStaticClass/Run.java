package com.lzd.two.innerStaticClass;

import com.lzd.two.innerStaticClass.PublicClass.PrivateClass;

/**
 * 运行静态内部类，可以直接实例化
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
		PrivateClass privateClass = new PrivateClass();
		privateClass.setAge("ageValue");
		privateClass.setAddress("addressValue");
		System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
	}
}
