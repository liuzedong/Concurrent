package com.lzd.eventAction.companent;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Label;

/**
 * <applet code="LabelDemo" width=200 height=200></applet>
 * 标签案例，在面板上面添加三个标签
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class LabelDemo extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 初始化的时候加载标签
	@Override
	public void init() {
		Label one = new Label("第一个");
		Label two = new Label("第二个");
		Label three = new Label("第三个");
		
		add(one);
		add(two);
		add(three);
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		
	}
	

}
