package com.lzd.eventAction;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 <applet code="SampleFonts" width=200 height=100></applet>
 */
/**
 * 字体使用案例，每次点击的时候，就更换下字体
 * @date 2016年9月26日
 * @author lzd
 *
 */
public class SampleFonts extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 定义下一个字体，字体，和显示的文字
	int next = 0;
	Font f;
	String msg;

	// 初始化的添加鼠标点击事件
	@Override
	public void init() {
		f = new Font("Dialog", Font.PLAIN, 12);
		msg = "我是显示的文字";
		setFont(f);
		addMouseListener(new MyMouseAdapter(this));
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString(msg, 4, 20);
	}
	
}

class MyMouseAdapter extends MouseAdapter {

	SampleFonts sampleFonts;
	
	public MyMouseAdapter(SampleFonts sampleFonts) {
		this.sampleFonts = sampleFonts;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 更换字体增加
		sampleFonts.next++;
		switch (sampleFonts.next){
			case 0 :
				sampleFonts.f = new Font("Dialog", Font.PLAIN, 12);
				sampleFonts.msg = "Dialog";
				break;
			case 1 :
				sampleFonts.f = new Font("DialogInput", Font.PLAIN, 12);
				sampleFonts.msg = "DialogInput";
				break;
			case 2 :
				sampleFonts.f = new Font("SansSerif", Font.PLAIN, 12);
				sampleFonts.msg = "SansSerif";
				break;
			case 3 :
				sampleFonts.f = new Font("Serif", Font.PLAIN, 12);
				sampleFonts.msg = "Serif";
				break;
			case 4 :
				sampleFonts.f = new Font("Monospaced", Font.PLAIN, 12);
				sampleFonts.msg = "Monospaced";
				break;
			case 5 : 
				sampleFonts.f = new Font("宋体", Font.PLAIN, 25);
				sampleFonts.msg = "宋体";
				break;
		}
		
		if (sampleFonts.next == 5){
			sampleFonts.next = -1;
		}
		sampleFonts.setFont(sampleFonts.f);
		sampleFonts.repaint();
		
	}
	
}
