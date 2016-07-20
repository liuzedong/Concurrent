package com.lzd.module.Component;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * 复选框类
 * @date 2016年7月20日
 * @author lzd
 *
 */
public class Input implements TextListener, ActionListener{

	// 创建成员变量
	// 窗口对象
	Frame f;
	// 面板对象
	Label lb, lb1;
	// 定义输入框对象
	TextField tf;
	// 定义TextArea对象
	TextArea ta1, ta2, ta3, ta4;
	
	// 主方法用来启动
	public static void main(String[] args) {
		new Input();
	}
	
	
	// 构造方法，用来定义组件的所有属性
	public Input(){
		f = new Frame("输入用户界面");
		// 设置窗口的布局管理器
		f.setLayout(new GridLayout(7, 1));
		// 创建和设置TextField
		tf = new TextField("", 20);
		tf.addTextListener(this);
		tf.addActionListener(this);
		
		lb = new Label();
		f.add(tf);
		f.add(lb);
		
		// 创建和设置TextArea对象
		ta1 = new TextArea("", 2, 10, TextArea.SCROLLBARS_NONE);
		ta2 = new TextArea("", 2, 10, TextArea.SCROLLBARS_HORIZONTAL_ONLY);
		ta3 = new TextArea("", 2, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta4 = new TextArea("", 2, 10, TextArea.SCROLLBARS_BOTH);
		
		// 为每个TextArea添加监听事件
		ta1.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				lb1.setText(ta1.getText());
			}
		});
		ta2.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				lb1.setText(ta2.getText());
			}
		});
		ta3.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				lb1.setText(ta3.getText());
			}
		});
		ta4.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				lb1.setText(ta4.getText());
			}
		});
		
		lb1 = new Label();
		f.add(ta1);
		f.add(ta2);
		f.add(ta3);
		f.add(ta4);
		f.add(lb1);
		
		
//		f.setSize(500, 500);
		f.pack();
		f.setVisible(true);
	}
	
	
	@Override
	public void textValueChanged(TextEvent e) {
		lb.setText(tf.getText());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tf.setText("");
	}

}
