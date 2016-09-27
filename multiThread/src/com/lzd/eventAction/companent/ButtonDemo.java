package com.lzd.eventAction.companent;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 按钮的案例，创建三个按钮，为每个按钮添加事件
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class ButtonDemo extends Applet implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String msg = "";
	Button yes, no, maybe;
	
	// 添加三个按钮组件
	@Override
	public void init() {
		yes = new Button("Yes");
		no = new Button("No");
		maybe = new Button("Undecided");
		
		add(yes);
		add(no);
		add(maybe);
		
		// 为每个按钮添加事件
		yes.addActionListener(this);
		no.addActionListener(this);
		maybe.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 获得点击事件的源的标签，就是按钮中的名称
		String str = e.getActionCommand();
		
		switch (str){
			case "Yes" :
				msg = "You pressed Yes";
				break;
			case "No" :
				msg = "You pressed No";
				break;
			case "Undecided" :
				msg = "You pressed Maybe";
				break;
			default :
				msg = "你按的这个按钮，我没有创建过的哦";
				break;
		}
		repaint();
	}

	
	@Override
	public void paint(Graphics g) {
		g.drawString(msg, 10, 100);
	}
	
	
	
	
}
