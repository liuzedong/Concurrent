package com.lzd.eventAction;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 <applet code="ResizeMe" width=200 height=200></applet>
 */
/**
 * 重新绘制应用
 * @date 2016年9月24日
 * @author lzd
 *
 */
public class ResizeMe extends Applet{

	private static final long serialVersionUID = 1L;
	
	final int inc = 25;
	int max = 500;
	int min = 200;
	Dimension d;
	
	public ResizeMe(){
		addMouseListener(new MouseAdapter() {
			// 按下鼠标出发的事件
			@Override
			public void mouseReleased(MouseEvent e) {
				int w = (d.width + inc) > max ? min : (d.width + inc);
				int h = (d.height + inc) > max ? min : (d.height + inc);
				setSize(new Dimension(w, h));
			}
		});
	}
	
	
	@Override
	public void paint(Graphics g) {
		d = getSize();
		System.out.println("widht : " + d.width + ",height : " + d.height);
		g.drawLine(0, 0, d.width -1 , d.height -1);
		g.drawLine(0, d.height - 1, d.width -1, 0);
		g.drawRect(0, 0, d.width -1, d.height -1);
	}
	
}
