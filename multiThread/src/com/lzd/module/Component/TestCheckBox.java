package com.lzd.module.Component;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 单选框和复选框的使用案例
 * @date 2016年7月19日
 * @author lzd
 *
 */
public class TestCheckBox implements ItemListener{

	// 创建成员变量
	// 窗口对象
	Frame f;
	
	// 创建两组复选框对象
	Checkbox[] cb = new Checkbox[3];
	Checkbox[] cbg = new Checkbox[3];
	
	// 创建一个复选框组
	CheckboxGroup cbg1 = new CheckboxGroup();
	
	
	// 主函数直接运行
	public static void main(String[] args) {
		new TestCheckBox();
	}
	
	public TestCheckBox(){
		f = new Frame("Checkbox组件的使用");
		// 设置窗口的布局
		f.setLayout(new GridLayout(2, 3));
		// 为cb数组赋值
		cb[0] = new Checkbox("复选框1");
		cb[1] = new Checkbox("复选框2", true);// 默认被选中
		cb[2] = new Checkbox();
		cb[2].setLabel("复选框3");
		
		
		// 为cbg数组赋值
		cbg[0] = new Checkbox("单选按钮1");
		cbg[0].setCheckboxGroup(cbg1);
		cbg[1] = new Checkbox("单选按钮2", true);
		cbg[1].setCheckboxGroup(cbg1);
		cbg[2] = new Checkbox("单选按钮3", cbg1, false);

		// 使用for循环来为cb注册监听事件
		for (int i = 0; i < cb.length; i++) {
			cb[i].addItemListener(this);
			f.add(cb[i]);
		}
		
		
		// 通过for循环来为cbg注册监听事件
		for (int i = 0; i < cbg.length; i++) {
			cbg[i].addItemListener(this);
			f.add(cbg[i]);
		}
		
		
		f.pack();
		
		f.setSize(500, 100);
		f.setVisible(true);
	}
	
	
	// 实现事件监听
	@Override
	public void itemStateChanged(ItemEvent e) {
		// 获取发生事件的组件对象
		Checkbox ch = (Checkbox) e.getSource();
		
		// 获得该组件的标签，就是标题
		String label = ch.getLabel();
		
		// 判断下，该组件是否被选中
		if(e.getStateChange() == ItemEvent.SELECTED){
			f.setTitle(label + "被选中"); 
		}else {
			f.setTitle(label + "取消选中"); 
		}
		
	}

}
