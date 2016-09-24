package com.lzd.eventAction;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 <applet code="GraphicsDemo" width=350 height-=700>
 </applet>
 */

/**
 * 在Applet中画画，画一些形状
 * @date 2016年9月24日
 * @author lzd
 *
 */
public class GraphicsDemo extends Applet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		// add mouseListener
		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				int widthX = e.getX();
				int heightY = e.getY();
				showStatus("X:" + widthX +",Y" + heightY);
//				repaint();
			}
		});
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		
		
		// Graphics is draw Object
		// Draw Lines
		g.drawLine(0, 0, 100, 10);
		g.drawLine(0, 90, 100, 10);
		g.drawLine(40, 25, 250, 80);
		
		
		// Draw rectangle
		g.drawRect(10, 150, 60, 20);
		g.fillRect(100, 150, 50, 50);
		// 两个15, 是指上下两边和左右两边的弧度
		g.drawRoundRect(190, 150, 60, 50, 15, 15);
		g.fillRoundRect(260, 150, 60, 50, 30, 30);
		
		
		// Draw Ellipses and Circles
		g.drawOval(10, 250, 50, 50);
		g.fillOval(90, 250, 50, 50);
		// 椭圆，后面两个参数设置的
		g.drawOval(190, 260, 100, 40);
		
		// Draw Arcs
		g.drawArc(10, 350, 70, 70, 0, 180);
		g.drawArc(60, 350, 70, 70, 0, 75);
		
		// Draw polygon
		int xpoints[] = {10, 200, 10, 200, 10};
		int ypoints[] = {450, 450, 650, 650, 450};
		int num = 5;
		g.drawPolygon(xpoints, ypoints, num);
		
	}

}
