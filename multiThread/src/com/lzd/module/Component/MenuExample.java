package com.lzd.module.Component;

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

/**
 * 菜单组件类的使用
 * @date 2016年7月21日
 * @author lzd
 *
 */
public class MenuExample extends MouseAdapter implements ActionListener{

	// 窗口对象
	Frame f;
	Label l;
	// 创建快捷菜单对象
	PopupMenu pm;
	
	public static void main(String[] args) {
		new MenuExample();
	}
	
	public MenuExample(){
		f = new Frame("使用菜单组件");
		f.addMouseListener(this);
		// 创建和设置item1的菜单
		MenuItem item1_1 = new MenuItem("item1_1");
		MenuItem item1_2 = new MenuItem("item1_2");
		MenuItem item1_3 = new MenuItem("item1_3");
		
		// 为各个菜单项添加事件监听器
		item1_1.addActionListener(this);
		item1_2.addActionListener(this);
		item1_3.addActionListener(this);
		
		// 创建菜单Item1
		Menu item1 = new Menu("item1", false);
		item1.add(item1_1);
		item1.add(item1_2);
		item1.add(item1_3);
		
		// 创建菜单项的快捷方式
		MenuShortcut ms = new MenuShortcut(KeyEvent.VK_A, false);
		MenuItem item2 = new MenuItem("Item2", ms);
		
		// 添加事件监听器
		item2.addActionListener(this);
		
		// 创建具有复选框的菜单项
		CheckboxMenuItem item3 = new CheckboxMenuItem("Item3");
		item3.addActionListener(this);
		
		// 创建和设置菜单
		Menu menu1 = new Menu("Menu1");
		menu1.add(item1);
		menu1.add(item2);
		// 添加分割线
		menu1.addSeparator();
		menu1.add(item3);
		
		// 创建和设置菜单help
		Menu help = new Menu("Help");
		MenuItem help1 = new MenuItem("Index");
		MenuItem help2 = new MenuItem("About");
		// 添加事件监听器
		help1.addActionListener(this);
		help2.addActionListener(this);
		help.add(help1);
		// 添加分割线
		help.addSeparator();
		help.add(help2);
		
		
		// 创建菜单项
		MenuItem popup1 = new MenuItem("popup1");
		MenuItem popup2 = new MenuItem("popup2");
		popup1.addActionListener(this);
		popup2.addActionListener(this);
		
		// 创建和设置快捷菜单pm
		pm = new PopupMenu();
		pm.add(popup1);
		pm.add(popup2);
		
		// 创建和设置菜单栏对象mb
		MenuBar mb = new MenuBar();
		mb.add(menu1);
		mb.setHelpMenu(help);
		f.setMenuBar(mb);
		
		l = new Label("没有菜单选项被选中");
		f.add(pm);
		f.add(l, BorderLayout.NORTH);
		f.setSize(200, 100);
		f.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MenuItem mi = (MenuItem) e.getSource();
		l.setText(mi.getLabel() + " 被选中");
	}
	

}
