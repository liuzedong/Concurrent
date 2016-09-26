package com.lzd.eventAction;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

/*
 <applet code="ShowFonts" width=500 height=60></applet>
 */
/**
 * 显示所有可用字体
 * @date 2016年9月26日
 * @author lzd
 *
 */
public class ShowFonts extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		String msg = "";
		String FontList[];
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		// 获得所有字体
		FontList = ge.getAvailableFontFamilyNames();
		for (int i = 0; i < FontList.length; i++) {
			msg += FontList[i] + "\r\n";
		}
		
		
		// 将获取到的字体，显示出来
		g.drawString(msg, 4, 10);
		
	}
}
