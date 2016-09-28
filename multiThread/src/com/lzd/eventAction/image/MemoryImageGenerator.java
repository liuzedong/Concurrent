package com.lzd.eventAction.image;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;

/**
 * 使用MemoryImage 创建图片，这里使用简单的算法进行画出的
 * 在数组中创建RGB 的像素值，然后画出来
 * @date 2016年9月28日
 * @author lzd
 *
 */
public class MemoryImageGenerator extends Applet{

	private static final long serialVersionUID = 1L;
	
	
	Image img;
	
	@Override
	public void init() {
		// 获得屏幕的大小，并设置为窗口的大小
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		Dimension d = getSize();
		int w = d.width;
		int h = d.height;
		// 创建画出图像的数组
		int[] pixeis = new int[w * h];
		int i = 0;
		
		// 将所有的颜色像素画出来
		for (int y=0; y<h; y++){
			for (int x=0; x<w; x++){
				int r = (x^y) & 0xff;
				int g = (x*2^y*2) & 0xff;
				int b = (x*4^y*4) & 0xff;
				pixeis[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
			}
		}
		img = createImage(new MemoryImageSource(w, h, pixeis, 0, w));
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
}
