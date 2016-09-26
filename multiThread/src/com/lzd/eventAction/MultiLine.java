package com.lzd.eventAction;

import java.applet.Applet;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * <applet code="MultiLine" width=300 height=200></applet>
 * 
 * 显示多行文本，使用FontMetrics 跟踪当前文本的输出位置
 * @date 2016年9月26日
 * @author lzd
 *
 */
public class MultiLine extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int curX = 0, curY = 0;

	@Override
	public void init() {
		Font f = new Font("宋体", Font.PLAIN, 16);
		setFont(f);
	}
	
	// 开始画文字
	@Override
	public void paint(Graphics g) {
		nextLine("This is on line one", g);
		nextLine("This is on ine two", g);
		sameLine("This is on same line", g);
		sameLine("This is on line Three", g);
		curX = curY = 0;
	}
	
	
	void nextLine(String s, Graphics g){
		FontMetrics fm = g.getFontMetrics();
		curY += fm.getHeight();
		curX = 0;
		g.drawString(s, curX, curY);
		curX = fm.stringWidth(s);
	}
	
	void sameLine(String s, Graphics g){
		FontMetrics fm = g.getFontMetrics();
		g.drawString(s, curX, curY);
		curX += fm.stringWidth(s);
	}
	
	
}
