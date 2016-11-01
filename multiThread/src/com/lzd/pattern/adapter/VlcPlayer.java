package com.lzd.pattern.adapter;
/**
 * 用于播放Vlc 的播放类
 * @date 2016年11月1日
 * @author lzd
 *
 */
public class VlcPlayer implements AdvancedMediaPlayer{

	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing vlc file name : " + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// 什么都不做
	}

}
