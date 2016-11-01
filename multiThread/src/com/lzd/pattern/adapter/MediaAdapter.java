package com.lzd.pattern.adapter;
/**
 * 播放的适配器
 * @date 2016年11月1日
 * @author lzd
 *
 */
public class MediaAdapter implements MediaPlayer{

	AdvancedMediaPlayer advancedMediaPlayer;
	
	/**
	 * 构造方法，指定播放类型，然后根据播放类型，创建指定的播放器
	 * @param audioType 指定播放类型
	 */
	public MediaAdapter(String audioType){
		if ("vlc".equalsIgnoreCase(audioType)) {
			advancedMediaPlayer = new VlcPlayer();
		} else if ("mp4".equalsIgnoreCase(audioType)){
			advancedMediaPlayer = new Mp4Player();
		}
	}
	
	
	@Override
	public void play(String audioType, String fileName) {
		if ("vlc".equalsIgnoreCase(audioType)) {
			advancedMediaPlayer.playVlc(fileName);;
		} else if ("mp4".equalsIgnoreCase(audioType)){
			advancedMediaPlayer.playMp4(fileName);;
		}
	}

}
