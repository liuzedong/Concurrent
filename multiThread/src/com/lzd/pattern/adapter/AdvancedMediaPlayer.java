package com.lzd.pattern.adapter;
/**
 * 媒体播放器，和上一个接口是两个使用的
 * 指定的方法，进行播放指定的文件
 * @date 2016年11月1日
 * @author lzd
 *
 */
public interface AdvancedMediaPlayer {

	/**
	 * 播放Vlc 文件
	 * @param fileName 文件名称
	 * @author 刘泽栋 2016年11月1日 下午5:28:17
	 */
	public void playVlc (String fileName);
	
	/**
	 * 播放Mp4 文件
	 * @param fileName 文件名称
	 * @author 刘泽栋 2016年11月1日 下午5:29:14
	 */
	public void playMp4 (String fileName);
}
