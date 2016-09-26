package com.lzd.eventAction;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/*
 <applet code="ColorDemo" width=300 height=200></applet>
 */
/**
 * 在绘画上使用颜色的案例
 * @date 2016年9月26日
 * @author lzd
 *
 */
public class ColorDemo extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Override
	public void paint(Graphics g) {
		Color c1 = new Color(255, 100, 100);
		Color c2 = new Color(100, 255, 100);
		Color c3 = new Color(100, 100, 255);
		
		
		g.setColor(c1);
		g.drawLine(0, 0, 100, 100);
		g.drawLine(0, 100, 100, 0);
		
		g.setColor(c2);
		g.drawLine(40, 25, 250, 180);
		g.drawLine(75, 90, 400, 400);
		
		g.setColor(c3);
		g.drawLine(20, 150, 400, 400);
		g.drawLine(5, 290, 80, 19);
		
		
		
		
	}
	
}
