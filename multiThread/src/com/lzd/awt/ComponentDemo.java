package com.lzd.awt;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Component组件的使用示例
 * @date 2016年8月22日
 * @author lzd
 *
 */
public class ComponentDemo {
	
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("abc");
		// 设置高度和宽度
		jf.setSize(500, 500);
		// 设置默认的显示位置
		jf.setLocation(0, 0);
		// 设置框口可以关闭
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JButton button = new JButton("按钮");
		JButton button2 = new JButton("按钮2");
		// 东
		jf.add(button, BorderLayout.EAST);
		// 西
		jf.add(button2, BorderLayout.WEST);
		
		// 设置框口为显示状态
		jf.setVisible(true);
	}
	

}
