package com.lzd.module.Component;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;

/**
 * ScrollPane的使用，滚动面板的使用
 * 一个面板panel对象，一个滚动面板对象ScrollPanel，多个按钮对象Button
 * 多个按钮对象在一个面板对象上，一个面板对象在一个滚动面板对象上
 * Panel对象的大小，决定ScrollPanel对象是否有滚动条
 * @date 2016年7月20日
 * @author lzd
 *
 */
public class ScrollPaneTest {
	
	public static void main(String[] args) {
		Frame f = new Frame("滚动面板的使用");
		// 获取第一个输入参数
		int n = Integer.parseInt(args[0]);
		// 创建一个面板对象
		Panel p = new Panel(new FlowLayout());
		
		Button btn[] = new Button[n];
		
		// 设置按钮
		for (int i = 0; i < n; i++) {
			btn[i] = new Button("按钮" + i);
			p.add(btn[i]);
		}
		
		// 创建滚动面板
		ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		sp.add(p);
		f.add(sp);
		f.pack();
		f.setVisible(true);
	}
}
