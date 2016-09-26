package com.lzd.eventAction;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * <applet code="CenterText" width=200 height=100></applet>
 * 将文本进行居中显示
 * @date 2016年9月26日
 * @author lzd
 *
 */
public class CenterText extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final Font f = new Font("宋体", Font.BOLD, 18);
	
	
	@Override
	public void paint(Graphics g) {
		// 获得当前面板的大小对象
		Dimension d = this.getSize();
		System.out.println("高：" + d.getHeight() + ", 宽：" + d.getWidth());
		
		// 设置在面板上面画东西，使用的颜色
		g.setColor(Color.white);
		// 填充一个白色的正方形
		g.fillRect(0, 0, d.width, d.height);
		// 重新设置颜色和字体
		g.setColor(Color.black);
		g.setFont(f);
		
		drawCenteredString("我在中间写字", d.width, d.height, g);
		
		// 画一个文本的边框
		g.drawRect(0, 0, d.width-1, d.height-1);
		
	}

	/**
	 * 在面板上面的中间写字
	 * @param msg
	 * @param w
	 * @param h
	 * @param g
	 * @author 刘泽栋 2016年9月26日 下午2:12:00
	 */
	public void drawCenteredString(String msg, int w, int h, Graphics g){
		// 获得字体的样式
		 FontMetrics fm = g.getFontMetrics();
		 // 计算出文本的中间位置，使用面板的位置，减去字体的位置
		 int x = (w - fm.stringWidth(msg)) / 2;
		 int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		 g.drawString(msg, x, y);
	}

}
