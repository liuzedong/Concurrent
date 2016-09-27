package com.lzd.eventAction.companent;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 列表的案例
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class ListDemo extends Applet implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List os, browser;
	String msg;
	
	@Override
	public void init() {
		os = new List(4, true);
		browser = new List(4, false);
		
		os.add("Windows");
		os.add("Android");
		os.add("Solaris");
		os.add("Mac OS");
		
		browser.add("Internet Explorer");
		browser.add("Firefox");
		browser.add("Chrome");
		
		browser.select(1);
		
		add(os);
		add(browser);
		
		os.addActionListener(this);
		browser.addActionListener(this);
	}

	
	@Override
	public void paint(Graphics g) {
		int idx[];
		msg = "Current OS : ";
		// 获得所有的下标
		idx = os.getSelectedIndexes();
		for (int i = 0; i < idx.length; i++) {
			msg += os.getItem(idx[i]) + " ";
		}
		g.drawString(msg, 10, 120);
		msg = "Current Browser : ";
		msg += browser.getSelectedItem();
		g.drawString(msg, 10, 140);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

}
