package com.lzd.eventAction;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*
<applet code="MouseEvents" width=300 height=100>
</applet>
*/
public class MouseEvents extends Applet implements MouseListener, MouseMotionListener{
	
	private static final long serialVersionUID = 1L;

	String msg = "";
	
	int mouseX = 0, mouseY = 0;
	
	@Override
	public void init() {
		setBackground(Color.RED);
		setForeground(Color.BLUE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		g.drawString(msg, mouseX, mouseY);
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		mouseX = 0;
		mouseY = 10;
		msg = "鼠标点击";
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		msg = "鼠标按下";
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		msg = "鼠标弹起";
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouseX = 0;
		mouseY = 10;
		msg = "鼠标进入";
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseX = 0;
		mouseY = 10;
		msg = "鼠标移除";
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		msg = "鼠标拖动";
		showStatus("鼠标拖动位置：" + mouseX + "," + mouseY);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		msg = "鼠标移动";
		showStatus("鼠标移动位置：" + mouseX + "," + mouseY);
		repaint();
	}

}
