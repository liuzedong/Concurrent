package com.lzd.module.Component;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Java中各个组件的使用案例
 * @date 2016年7月19日
 * @author lzd
 *
 */
public class BaseComponent implements ActionListener{

	
	// 创建成员变量
	// 窗口对象
	Frame f;
	// 面板对象
	Label result;
	// 两个按钮对象
	Button b1, b2;
	
	// 主方法，创建该对象，直接使用构造方法中的参数来显示面板
	public static void main(String[] args) {
		new BaseComponent();
	}
	
	
	public BaseComponent(){
		// 为窗口对象和面板对象赋值
		f = new Frame("基本组件");
		result = new Label("检查那个按钮被点击啦");
		
		// 为按钮对象赋值和设置
		b1 = new Button("左边");
		// 设置按钮的大小
		b1.setSize(50, 100);
		// 设置按钮的ActionCommand
		b1.setActionCommand("b1");
		// 注册监听事件
		b1.addActionListener(this);
		
		
		b2 = new Button("右边");
		b2.setSize(50, 100);
		b2.setActionCommand("b2");
		b2.addActionListener(this);
		
		
		// 将两个按钮和面板添加到窗口上
		f.add(result, BorderLayout.NORTH);
		f.add(b1, BorderLayout.WEST);
		f.add(b2, BorderLayout.EAST);
		f.pack();
		f.setVisible(true);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 获取设置的变量，就是设置的b1和b2
		String command = e.getActionCommand();
		if("b1".endsWith(command)){
			// 将b2按钮 设置成为不能点击
			b2.setEnabled(!b2.isEnabled());
			// 然后设置面板的文字
			result.setText("左键被点击啦");
		}
		if("b2".endsWith(command)){
			b1.setEnabled(!b1.isEnabled());
			result.setText("右键被点击啦");
		}
		
	}

}
