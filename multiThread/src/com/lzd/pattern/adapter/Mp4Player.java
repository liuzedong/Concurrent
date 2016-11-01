package com.lzd.pattern.adapter;
/**
 * 用于播放MP4的播放器
 * @date 2016年11月1日
 * @author lzd
 *
 */
public class Mp4Player implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		// 什么都不做
	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing Mp4 file name : " + fileName);
	}

}
