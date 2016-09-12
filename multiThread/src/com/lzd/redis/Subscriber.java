package com.lzd.redis;

import java.util.logging.Level;
import java.util.logging.Logger;

import redis.clients.jedis.JedisPubSub;

/**
 * 消息订阅的继承类，需要使用到的
 * 用它订阅一些频道，并获得消息
 * @date 2016年8月31日
 * @author lzd
 *
 */
public class Subscriber extends JedisPubSub{
	
	private static final Logger log = Logger.getLogger(Subscriber.class.getCanonicalName());

	@Override
	public void onMessage(String channel, String message) {
		log.log(Level.INFO,  "Message received. Channel: {}, Msg: {}" + channel + message);
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		// TODO Auto-generated method stub
		super.onPMessage(pattern, channel, message);
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onSubscribe(channel, subscribedChannels);
	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onUnsubscribe(channel, subscribedChannels);
	}

	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onPUnsubscribe(pattern, subscribedChannels);
	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onPSubscribe(pattern, subscribedChannels);
	}

}
