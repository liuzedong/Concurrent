package com.lzd.eventAction.companent;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 通过对象创建复选框，类似与单选框
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class CBGroup extends Applet implements ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String msg = "";
	Checkbox windows, android, solaris, mac, linux;
	CheckboxGroup cbg;
	
	@Override
	public void init() {
		cbg = new CheckboxGroup();
		
		windows = new Checkbox("Windows", cbg, false);
		android = new Checkbox("Android", cbg, false);
		solaris = new Checkbox("Solaris", cbg, false);
		mac = new Checkbox("Mac", cbg, false);
		linux = new Checkbox("Linux", cbg, true);
		
		add(windows);
		add(android);
		add(solaris);
		add(mac);
		add(linux);
		
		windows.addItemListener(this);
		android.addItemListener(this);
		solaris.addItemListener(this);
		mac.addItemListener(this);
		linux.addItemListener(this);
		
	}
	
	// 选中的时候触发的事件
	@Override
	public void itemStateChanged(ItemEvent e) {
		repaint();		
	}

	@Override
	public void paint(Graphics g) {
		msg = "Current state : ";
		msg += cbg.getSelectedCheckbox().getLabel();
		g.drawString(msg, 6, 100);
	}
	
	
}
