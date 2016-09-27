package com.lzd.eventAction.layoutManager;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;

/**
 * 设置每个控件之间的距离
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class InsetsDemo extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		// 设置背景颜色
		setBackground(Color.cyan);
		
		setLayout(new BorderLayout());
		setFont(new Font("宋体", Font.BOLD, 24));
		
		// 添加控件，并指定控件所在的位置，北方
		add(new Button("This is acrros the top"), BorderLayout.NORTH);
		// 南方，下面
		add(new Label("The footer message might go here"), BorderLayout.SOUTH);
		
		// 东方，右边
		add(new Button("Right"), BorderLayout.EAST);
		// 西方，左边
		add(new Button("Left"), BorderLayout.WEST);
		
		// 添加文本，放置在中间
		String msg = "这里是我写的\n"
				+ "放在中间部分的文字\n"
				+ "你想他是什么就是什么\n"
				+ "哈哈结尾。";
		add(new TextArea(msg), BorderLayout.CENTER);
	}

	// 重写getInsets方法，进行设置每个控件之间的距离
	// 就是设置四个方位控件到边境的边距
	@Override
	public Insets getInsets() {
		return new Insets(10, 50, 10, 10);
	}
	
	
}
