package com.lzd.nosafe;
/**
 * 买票的对象
 * @date 2016年7月10日
 * @author lzd
 */
public class Tickets implements Runnable{

	int tickets = 4;	// 总共有4张票
	
	
	// 模拟买票的动作
	@Override
	public void run() {
		while(true){
			// 当还有票的时候，就进行动作
			if(tickets > 0){
				System.out.println("顾客到达：" + Thread.currentThread().getName() + "售票台");
				System.out.println("售票台：" + Thread.currentThread().getName() + "准备卖第" + tickets + "张皮");
				
				try{
					// 具体的买票过程
					System.out.println("买票需要五分钟");
					for (int i = 1; i <= 5; i++) {
						Thread.sleep(5);
						System.out.println(i + "分钟");
					}
					
					// 输出相应的详细，购票成功
					System.out.println("售票台" + Thread.currentThread().getName() + "卖完第" + tickets + "张票");
					System.out.println("顾客从：" + Thread.currentThread().getName() + "售票台买到票");
					
					// 这个票卖完啦，就进行减掉一个
					--tickets;
					
					
				}catch(Exception e){
					System.out.println("买票不成功");
					System.exit(1);
				}
				
				
			}
			
			
			
		}
	}

}
