package com.lzd.eventAction.layoutManager;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;

/**
 * 方位布局管理器的使用，使用的东南西北中，这些方向
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class BorderLayoutDemo extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	// 初始化的时候，指定默认的管理器
	@Override
	public void init() {
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

}
