package com.lzd.pattern.adapter;

/**
 * 测试类， 其实，就是在一个原有的音乐系统之中加上其他的文件 那么就再写一个类似的播放功能，然后，使用一个适配器类，将这两个系统进行连接起来
 * 注意，一般不会再新项目中使用适配器模式，这个模式一般是在已完成的项目中 然后，需要新加功能，才做适配器进行添加功能，对原有系统不进行破坏
 * 
 * @date 2016年11月1日
 * @author lzd
 * 
 */
public class AdapterPatternDemo {

	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();

		audioPlayer.play("mp3", "beyond the horizon.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "far far away.vlc");
		audioPlayer.play("avi", "mind me.avi");

	}

}
