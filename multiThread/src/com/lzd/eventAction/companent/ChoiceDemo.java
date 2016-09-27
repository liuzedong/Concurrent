package com.lzd.eventAction.companent;

import java.applet.Applet;
import java.awt.Choice;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 下拉框的案例
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class ChoiceDemo extends Applet implements ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 一个操作系统的下拉框，和一个浏览器的下拉框
	Choice os, browser;
	String msg = "";
	
	@Override
	public void init() {
		os = new Choice();
		browser = new Choice();
		
		os.add("Windows");
		os.add("Android");
		os.add("Solaris");
		os.add("Mac OS");
		os.add("Linux");
		
		browser.add("Internet Explorer");
		browser.add("Firefox");
		browser.add("Chrome");
		browser.add("Baidu Browser");
		
		add(os);
		add(browser);
		
		os.addItemListener(this);
		browser.addItemListener(this);
		
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		repaint();
	}

	
	@Override
	public void paint(Graphics g) {
		msg = "Current OS : ";
		// 获取选中的下拉选项
		msg += os.getSelectedItem();
		g.drawString(msg, 10, 100);
		msg = "Current Browser : ";
		msg += browser.getSelectedItem();
		g.drawString(msg, 10, 140);
		
	}
}
