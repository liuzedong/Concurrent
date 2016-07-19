package com.lzd.module.Component;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 下拉菜单组件和列表组件的使用
 * @date 2016年7月19日
 * @author lzd
 *
 */
public class OptionsSelect implements ItemListener{
	
	// 创建三个成员变量
	// 窗口对象
	Frame f;
	// 列表对象
	List ls;
	// 下拉菜单对象
	Choice ch;
	
	
	// 主函数，直接运行就可以使用勒
	public static void main(String[] args) {
		new OptionsSelect(args);
	}
	
	public OptionsSelect(String[] args){
		f = new Frame("选项组件");
		// 列表组件ls的赋值和设置
		ls = new List(Integer.parseInt(args[0]), Boolean.valueOf(args[1]).booleanValue());
		// 为列表对象添加监听器
		ls.addItemListener(this);
		
		// 为列表添加选项
		for (int i = 2; i < args.length; i++) {
			ls.add(args[i]);
		}

		// 下拉菜单组件ch的赋值和设置
		ch = new Choice();
		// 通过匿名的方式来为ch添加事件
		ch.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice c = (Choice) e.getSource();
				System.out.println("下拉菜单中：" + c.getSelectedItem() + "选项的编号：" + c.getSelectedIndex());
				System.out.println("下拉菜单中：" + (c.getSelectedIndex() + 1) + "项被选中啦");
			}
		});
		
		
		// 为对象ch添加选项
		for (int i = 2; i < args.length; i++) {
			ch.add(args[i]);
		}
		
		// 向窗口中添加组件
		f.add(ls, BorderLayout.WEST);
		f.add(ch, BorderLayout.EAST);
		
		f.pack();
		f.setSize(200, 100);
		// 显示窗口
		f.setVisible(true);
		
		// 输出相应的信息
		System.out.println("下拉菜单中一共有： " + ch.getItemCount() + "项");
		System.out.println("列表中一共有：" + ls.getItemCount() + "项");
		
	}

	
	// 实现列表的监听事件
	@Override
	public void itemStateChanged(ItemEvent e) {
		List l = (List) e.getSource();
		int index[] = l.getSelectedIndexes();
		String str[] = l.getSelectedItems();
		
		for (int i = 0; i < index.length; i++) {
			System.out.println("列表的编号：" + index[i]);
			System.out.println("被选中的列表：" + str[i]);
		}
		
		
	}

}
