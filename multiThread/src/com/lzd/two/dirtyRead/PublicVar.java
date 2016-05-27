package com.lzd.two.dirtyRead;
/**
 * 放生脏读的情况，设置数据是同步的，但是在读取数据时，获取到不是同步的数据
 * 这就发生了脏读的情况
 * @date 2016年5月27日
 * @author lzd
 *
 */
public class PublicVar {

	public String username = "A";
	public String password = "AA";
	
	// 只对 设置值得方法进行同步
	synchronized public void setValue(String username, String password){
		try {
			this.username = username;
			Thread.sleep(5000);
			this.password = password;
			
			System.out.println("setValue method thread name = " + Thread.currentThread().getName() 
					+ ",username = " + username + ",password = " + password);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 读取数据没有进行同步
	public void getValue(){
		System.out.println("getValue method thread name = " + Thread.currentThread().getName() 
				+ ",username = " + username + ",password = " + password);
	}
}
