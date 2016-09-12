package com.lzd.redis;

import java.util.logging.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 用来订阅消息
 * @date 2016年8月31日
 * @author lzd
 *
 */
public class Program {
	
	public static final String CHANNEL_NAME = "commonChannel";
	
	private static final Logger log = Logger.getLogger(Program.class.getCanonicalName());
	
	public static void main(String[] args) {
		
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		// redis池，host，port，timeout，password
		JedisPool jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379, 0, "liudong");
		// 订阅者
		final Jedis subscriberJedis = jedisPool.getResource();
		
		// 真正的订阅者
		final Subscriber subscriber = new Subscriber();
		new Thread(new Runnable() {
			@Override
			public void run() {
				log.info("Subscribing to \"commonChannel\". This thread will be blocked.");
				subscriberJedis.subscribe(subscriber, CHANNEL_NAME);
			}
		});
		
	}
			

}
