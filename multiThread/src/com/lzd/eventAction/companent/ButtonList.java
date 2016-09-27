package com.lzd.eventAction.companent;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 按钮案例，通过点击，获取该点击事件源的属性
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class ButtonList extends Applet implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String msg = "";
	Button[] bList = new Button[3];
	
	@Override
	public void init() {
		Button yes = new Button("Yes");
		Button no = new Button("No");
		Button maybe = new Button("Undecided");
		
		bList[0] = (Button) add(yes);
		bList[1] = (Button) add(no);
		bList[2] = (Button) add(maybe);
		
		// 为每个组件添加事件
		for (int i = 0; i < bList.length; i++) {
			bList[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 3; i++) {
			// 获得每个对象，并且判断是不是这个对象
			if (e.getSource() == bList[i]){
				msg = "You pressed " + bList[i].getLabel();
			}
		}
		repaint();
	}

	
	@Override
	public void paint(Graphics g) {
		g.drawString(msg, 10, 100);
	}
	
}
