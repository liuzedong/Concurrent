package com.lzd.eventAction.layoutManager;

import java.applet.Applet;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 卡片布局管理器，就是一些面板，类似与卡片的形式叠加起来
 * 点击面板的时候切换，和点击按钮的时候切换
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class CardLayoutDemo extends Applet implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Checkbox windowsXP, windows7, windows8, android, solaris, mac;
	Panel osCards;
	CardLayout cardLO;
	Button win, other;
	
	@Override
	public void init() {
		win = new Button("Windows");
		other = new Button("Other");
		
		add(win);
		add(other);
		
		// 初始化面板和卡片布局管理器，并为面板设置布局管理器
		cardLO = new CardLayout();
		osCards = new Panel();
		osCards.setLayout(cardLO);
		
		// 初始化复选框
		windowsXP = new Checkbox("Windows XP", null, true);
		windows7 = new Checkbox("Windows 7", null, false);
		windows8 = new Checkbox("Windows 8", null, false);
		android = new Checkbox("Android");
		solaris = new Checkbox("Solaris");
		mac = new Checkbox("Mac OS");
		
		// 向面变中添加复选框的控件
		Panel winPan = new Panel();
		winPan.add(windowsXP);
		winPan.add(windows7);
		winPan.add(windows8);
		
		// 在另外一个面板中添加其他系统的复选框按钮
		Panel otherPan = new Panel();
		otherPan.add(android);
		otherPan.add(solaris);
		otherPan.add(mac);
		
		// 向卡片管理器中添加面板控件
		osCards.add(winPan, "Windows");
		osCards.add(otherPan, "Other");
		
		
		add(osCards);
		
		// 为框口中按钮添加事件
		win.addActionListener(this);
		other.addActionListener(this);
		
		addMouseListener(this);
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		cardLO.next(osCards);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == win){
			cardLO.show(osCards, "Windows");
		} else {
			cardLO.show(osCards, "Other");
		}
	}

}
