package com.lzd.pattern.adapter;
/**
 * 用于播放媒体的接口
 * @date 2016年11月1日
 * @author lzd
 *
 */
public interface MediaPlayer {
	
	/**
	 * 播放
	 * @param audioType 播放的格式
	 * @param fileName 播放文件的名称
	 * @author 刘泽栋 2016年11月1日 下午5:24:53
	 */
	public void play(String audioType, String fileName);

}
