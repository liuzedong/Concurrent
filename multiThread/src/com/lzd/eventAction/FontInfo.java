package com.lzd.eventAction;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;

/*
 <applet code="FontInfo" width=350 height=60></applet>
 */
/**
 * 获取字体的信息
 * @date 2016年9月26日
 * @author lzd
 *
 */
public class FontInfo extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		setFont(new Font("宋体", Font.BOLD, 34));
	}
	
	@Override
	public void paint(Graphics g) {
		Font f = g.getFont();
		// 获取字体的名称
		String fontName = f.getName();
		// 获得字体的家族
		String fontFamily = f.getFamily();
		// 获得字体的大小
		int fontSize = f.getSize();
		// 获得字体的样式
		int fontStyle = f.getStyle();
		
		// 将获取到的信息打印出来
		String msg = "fontName : " + fontName;
		msg += ", fontFamily : " + fontFamily;
		msg += ", fontSize : " + fontSize + ", fontStyle : ";
		
		if ((fontStyle & Font.BOLD) == Font.BOLD){
			msg += "Bold";
		}
		if ((fontStyle & Font.ITALIC) == Font.ITALIC){
			msg += "Italic";
		}
		if ((fontStyle & Font.PLAIN) == Font.PLAIN){
			msg += "Plain";
		}
		
		g.drawString(msg, 10, 35);
		g.drawString("我就是显示的", 10, 75);
		
		
	}
	
	

}
