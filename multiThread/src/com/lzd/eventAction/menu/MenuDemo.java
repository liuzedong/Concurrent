package com.lzd.eventAction.menu;

import java.applet.Applet;
import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 菜单栏的使用案例
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class MenuDemo extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Frame f;
	
	@Override
	public void init() {
		f = new MenuFrame("Menu Demo");
		int width = Integer.parseInt(getParameter("width"));
		int height = Integer.parseInt(getParameter("height"));
		
		setSize(new Dimension(width, height));
		
		f.setSize(width, height);
		f.setVisible(true);
	}
	
	@Override
	public void start() {
		f.setVisible(true);
	}
	
	@Override
	public void stop() {
		f.setVisible(false);
	}
}

/**
 *  创建的一个面板
 * @date 2016年9月27日
 * @author lzd
 *
 */
class MenuFrame extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String msg = "";
	CheckboxMenuItem debug, test;
	
	public MenuFrame(String title) {
		super(title);
		
		// 创建一个menu bar(菜单栏) 并且添加到面板中
		MenuBar mbar = new MenuBar();
		setMenuBar(mbar);
		
		// 创建菜单
		Menu file = new Menu("File");
		MenuItem item1, item2, item3, item4, item5;
		file.add(item1 = new MenuItem("New..."));
		file.add(item2 = new MenuItem("Open..."));
		file.add(item3 = new MenuItem("Close"));
		file.add(item4 = new MenuItem("-"));
		file.add(item5 = new MenuItem("Quit..."));
		mbar.add(file);
		
		Menu edit = new Menu("Edit");
		MenuItem item6, item7, item8, item9;
		edit.add(item6 = new MenuItem("Cut"));
		edit.add(item7 = new MenuItem("Copy"));
		edit.add(item8 = new MenuItem("Paste"));
		edit.add(item9 = new MenuItem("-"));
		
		Menu sub = new Menu("Special");
		MenuItem item10, item11, item12;
		sub.add(item10 = new MenuItem("First"));
		sub.add(item11 = new MenuItem("Second"));
		sub.add(item12 = new MenuItem("Third"));
		edit.add(sub);
		
		// 这个是多个菜单
		debug = new CheckboxMenuItem("Debug");
		edit.add(debug);
		test = new CheckboxMenuItem("Testing");
		edit.add(test);
		// 菜单栏，添加另外一个菜单
		mbar.add(edit);
		
		// 点击事件
		MyMenuHandler handler = new MyMenuHandler(this);
		item1.addActionListener(handler);
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		item4.addActionListener(handler);
		item5.addActionListener(handler);
		item6.addActionListener(handler);
		item7.addActionListener(handler);
		item8.addActionListener(handler);
		item9.addActionListener(handler);
		item10.addActionListener(handler);
		item11.addActionListener(handler);
		item12.addActionListener(handler);
		debug.addItemListener(handler);
		test.addItemListener(handler);
		
		MyWindowAdapter adapter = new MyWindowAdapter(this);
		addWindowListener(adapter);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString(msg, 10, 200);
		
		if(debug.getState()){
			g.drawString("Debug is on", 10, 220);
		}else {
			g.drawString("Debug is off", 10, 220);
		}
		
		if (test.getState()){
			g.drawString("Testing is on", 10, 240);
		}else {
			g.drawString("Testing is off", 10, 240);
		}
		
	}
	
}

/**
 * 窗口触发的事件
 * @date 2016年9月27日
 * @author lzd
 *
 */
class MyWindowAdapter extends WindowAdapter {
	MenuFrame menuFrame;
	
	public MyWindowAdapter(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		menuFrame.setVisible(false);
	}
	
}


/**
 * 点击时候触发的事件
 * @date 2016年9月27日
 * @author lzd
 *
 */
class MyMenuHandler implements ActionListener, ItemListener {

	MenuFrame menuFrame;
	
	public MyMenuHandler(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		menuFrame.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = "You selected ";
		String arg = e.getActionCommand();
		
		if (arg.equals("New..."))
			msg += "New.";
		else if (arg.equals("Open..."))
			msg += "Open.";
		else if (arg.equals("Close"))
			msg += "Close.";
		else if (arg.equals("Quit..."))
			msg += "Quit.";
		else if (arg.equals("Edit"))
			msg += "Edit.";
		else if (arg.equals("Cut"))
			msg += "Cut.";
		else if (arg.equals("Copy"))
			msg += "Copy.";
		else if (arg.equals("Paste"))
			msg += "Paste.";
		else if (arg.equals("First"))
			msg += "First.";
		else if (arg.equals("Second"))
			msg += "Second.";
		else if (arg.equals("Third"))
			msg += "Third.";
		else if (arg.equals("Debug"))
			msg += "Debug.";
		else if (arg.equals("Testing"))
			msg += "Testing.";
		menuFrame.msg = msg;
		menuFrame.repaint();
		
	}
	
}
