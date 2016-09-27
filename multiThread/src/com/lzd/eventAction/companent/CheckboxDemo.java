package com.lzd.eventAction.companent;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 复选框使用案例，并且为复选框添加选中的事件
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class CheckboxDemo extends Applet implements ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String msg = "";
	Checkbox windows, android, solaris, mac, linux;
	
	@Override
	public void init() {
		// 初始化每个复选框
		windows = new Checkbox("Windows");
		android = new Checkbox("Android");
		solaris = new Checkbox("Solaris");
		mac = new Checkbox("Mac");
		linux = new Checkbox("Linux", null, true);
		
		
		add(windows);
		add(android);
		add(solaris);
		add(mac);
		add(linux);
		
		// 为复选框添加事件
		windows.addItemListener(this);
		android.addItemListener(this);
		solaris.addItemListener(this);
		mac.addItemListener(this);
		linux.addItemListener(this);
	}
	
	
	
	
	// 当复选框被选中的时候，就会进入该事件中
	@Override
	public void itemStateChanged(ItemEvent e) {
		repaint();
	}

	
	@Override
	public void paint(Graphics g) {
		msg = "Current state : ";
		g.drawString(msg, 10, 80);
		msg = "Windows : " + windows.getState();
		g.drawString(msg, 10, 120);
		msg = "Android : " + android.getState();
		g.drawString(msg, 10, 140);
		msg = "Solaris : " + solaris.getState();
		g.drawString(msg, 10, 160);
		msg = "Mac : " + mac.getState();
		g.drawString(msg, 10, 180);
		msg = "Linux : " + linux.getState();
		g.drawString(msg, 10, 200);
		
	}
}
