package com.lzd.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * Redis 测试连接
 * @date 2016年8月30日
 * @author lzd
 *
 */
public class RedisClient {
	
	private static Jedis client;
	
	static {
		// 设置连接
		client = new Jedis("127.0.0.1", 6379);
		// 设置密码
		client.auth("liudong");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		/*String value = getValueByKey("1000002060001160000000890");
		System.out.println(value);*/
		/*String test = "刘泽栋是<name>刘真74</name>一个大好人";
		for (int i = 0; i <10; i++) {
			test = test.replaceAll("<name>刘真74</name>", "<name>刘真"+new Random().nextInt()+"</name>");
			System.out.println(test);
		}*/
		
		// 测试管道
		/*Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				Map<String, String> datas = new HashMap<String, String>();
				for (int i = 0; i < 100000; i++) {
					datas.put("1" + i , "测试数据");
				}
				pipelinedRedis(datas);
				System.out.println("管道：" + (System.currentTimeMillis() - start));
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				for (int i = 0; i < 100000; i++) {
					setString("2" + i , "测试数据");
				}
				System.out.println("非管道：" + (System.currentTimeMillis() - start));
			}
		});
		
		t1.start();
		t2.start();*/
		
		/*Set<String> keys = client.keys("*");
		System.out.println(keys);*/
		/*while(true){
			int s = new Random().nextInt(3);
			Thread.sleep(1000 * s);
			System.out.println(s);
		}*/
		/*Map<String, String> map = new HashMap<String, String>(); 
		map.put("", "刘东");
		map.put("", "asd");
		client.hmset("abc", map);*/
		String value = "abc";
		Long rpushx = client.rpush("PolicyApplicationList", value);
		System.out.println(rpushx);
		
	}
	
	/**
	 * 使用管道（Pipelining）操作redis，就是一次发送多个命令
	 * 
	 * @author 刘泽栋 2016年8月31日 上午9:54:32
	 */
	public static void pipelinedRedis(Map<String, String> datas){
		Pipeline pipelined = client.pipelined();
		Set<Entry<String, String>> keyAndValues = datas.entrySet();
		for (Entry<String, String> keyAndValue : keyAndValues) {
			// 装入输入
			pipelined.set(keyAndValue.getKey(), keyAndValue.getValue());
		}
		// 执行
		pipelined.sync();
//		pipelined.syncAndReturnAll();
//		System.out.println(responseData);
	}
	
	
	/**
	 * 向redis中插入 指定信息
	 * @param number 编号
	 * @param value 值
	 * @return
	 * @author 刘泽栋 2016年8月30日 下午4:11:05
	 */
	public static boolean setString(String number, String value){
		client.set(number, value);
//		System.out.println(status);
//		client.close();
		return true;
	}

	/**
	 * 插入数据，如果存在则不插入
	 * @return
	 * @author 刘泽栋 2016年8月30日 下午4:25:44
	 */
	public static boolean setOnlyString(String number, String value){
		Long setnx = client.setnx(number, value);
		return setnx == 1 ? true : false;
	}
	
	/**
	 * 查询所有key
	 * @return
	 * @author 刘泽栋 2016年8月30日 下午4:23:25
	 */
	public static Set<String> getAllKey(){
		return client.keys("*");
	}
	
	/**
	 * 查询指定的key
	 * @param key
	 * @return
	 * @author 刘泽栋 2016年8月30日 下午4:23:57
	 */
	public static String getValueByKey(String key){
		return client.get(key);
	}
	
}
