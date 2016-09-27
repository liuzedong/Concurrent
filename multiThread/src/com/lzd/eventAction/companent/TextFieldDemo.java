package com.lzd.eventAction.companent;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 文本框使用案例，输入账户和密码
 * 输入的信息，在下面显示，并且显示，选中的信息
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class TextFieldDemo extends Applet implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TextField name, pass;
	
	@Override
	public void init() {
		Label namep = new Label("Name : ", Label.RIGHT);
		Label passp = new Label("Password : ", Label.RIGHT);
		name = new TextField(12);
		pass = new TextField(8);
		
		add(namep);
		add(name);
		add(passp);
		add(pass);
		
		// 添加事件
		name.addActionListener(this);
		pass.addActionListener(this);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.drawString("Name: " + name.getText(), 6, 60);
		g.drawString("Selected text in name: " + name.getSelectedText(), 6, 80);
		g.drawString("Password: " + pass.getText(), 6, 100);
	}
	
	
}
