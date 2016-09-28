package com.lzd.eventAction.image;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * 使用双缓冲区，画出图片
 * @date 2016年9月28日
 * @author lzd
 *
 */
public class DoubleBuffer extends Applet{

	private static final long serialVersionUID = 1L;
	
	// 画的步长
	int gap = 3;
	// 鼠标的位置
	int mx, my;
	boolean flicker = true;
	Image buffer = null;
	// 面板的宽高
	int w, h;
	
	@Override
	public void init() {
		// 获取当前应用的大小
		Dimension d = getSize();
		w = d.width;
		h = d.height;
		// 创建一个全屏的画布
		buffer = createImage(w, h);
		
		// 添加鼠标移动和拖拽事件
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				mx = e.getX();
				my = e.getY();
				flicker = false;
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				mx = e.getX();
				my = e.getY();
				flicker = true;
				repaint();
			}
			
		});
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics screengc = null;
		
		if (!flicker){
			screengc = g;
			g = buffer.getGraphics();
		}
		
		g.setColor(Color.BLUE);
		// 画一个矩形
		g.fillRect(0, 0, w, h);
		
		g.setColor(Color.RED);
		for (int i = 0; i < w; i+=gap) {
			g.drawLine(i, 0, w-i, h);
		}
		for (int i = 0; i < h; i+=gap) {
			g.drawLine(0, i, w, h-i);
		}
		
		g.setColor(Color.BLACK);
		g.drawString("Press mouse button to double buffer", 10, h/2);
		
		g.setColor(Color.YELLOW);
		g.fillOval(mx - gap, my - gap, gap * 2 +1, gap*2+1);
		
		if (!flicker){
			screengc.drawImage(buffer, 0, 0, null);
		}
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}

}
