package com.lzd.two.private_variable;
/**
 * 私有变量是不会存在线程的不安全的
 * @date 2016年5月24日
 * @author lzd
 *
 */
public class HasSelfPrivateNum {

	public void addI(String username){
		try {
			int num = 0;
			if(username.equals("a")){
				num = 100;
				System.out.println("a set over!");
				Thread.sleep(2000);
			}else{
				num = 200;
				System.out.println("b set over!");
			}
			System.out.println(username + "num = " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
