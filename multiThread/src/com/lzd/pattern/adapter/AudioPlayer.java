package com.lzd.pattern.adapter;
/**
 * 音频播放器
 * @date 2016年11月1日
 * @author lzd
 *
 */
public class AudioPlayer implements MediaPlayer{

	MediaAdapter mediaAdapter;
	
	@Override
	public void play(String audioType, String fileName) {
		// 播放mp3 音乐文件的内置支持
		if ("mp3".equalsIgnoreCase(audioType)){
			System.out.println("Playing mp3 file name : " + fileName);
		}
		
		// 使用mediaAdapter来播放其他格式的文件
		else if ("vlc".equalsIgnoreCase(audioType)
				|| "mp4".equalsIgnoreCase(audioType)){
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		} else {
			System.out.println("Invalid media : " + fileName + " from not supported");
		}
		
	}

}
