package com.lzd.eventAction.image;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <applet code="SilpleImageLoad" width=400 height=345></applet>
 * 加载图像的简单案例
 * @date 2016年9月28日
 * @author lzd
 *
 */
public class SimpleImageLoad extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 定义图片成员变量
	Image img;
	
	@Override
	public void init() {
		// 初始化加载图片
		try {
			img = getImage(new URL("file:/home/liuzedong/git/Concurrent/multiThread/src/com/lzd/eventAction/image/"), "Lilites.jpg");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// 将图片画出来
		g.drawImage(img, 0, 0, this);
	}
	
	

}
