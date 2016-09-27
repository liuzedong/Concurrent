package com.lzd.eventAction.layoutManager;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * 使用网格布局，这里使用的4 × 4的布局
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class GridLayoutDemo extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static final int n = 4;
	
	@Override
	public void init() {
		// 设置布局管理器
		setLayout(new GridLayout(n, n));
		
		// 设置字体
		setFont(new Font("宋体", Font.BOLD, 24));
		
		/*for (int i = 1; i <= 15; i++) {
			add(new Button("" + i));
		}*/
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int k = i * n +j;
				if (k > 0){
					System.out.println(k);
					add(new Button("" + k));
				}
			}
		}
	}

}
