package com.lzd.eventAction;

import java.applet.Applet;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 <applet code="AppletFrame" width=300 height=50></applet>
 */
public class AppletFrame extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Frame f;
	
	@Override
	public void init() {
		// 初始化Applet
		f = new SampleFrame("A Frame Window");
		f.setSize(250, 250);
		f.setVisible(true);
		
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("我被点击啦");
				f.setVisible(true);
			}
		});
		
	}
	
	@Override
	public void start() {
		f.setVisible(true);
	}
	
	@Override
	public void stop() {
		System.out.println("窗口关闭");
		f.setVisible(false);
	}
	
	
	@Override
	public void destroy() {
		System.out.println("我是什么时候销毁的啊");
	}
}

/**
 * 窗口类
 * @date 2016年9月24日
 * @author lzd
 *
 */
class SampleFrame extends Frame{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 当创建这个窗口的时候，就会直接初始化，标题和窗口事件
	 * @param title
	 */
	public SampleFrame(String title) {
		super(title);
		MyWindowAdapter adapter = new MyWindowAdapter(this);
		addWindowListener(adapter);
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawString("This is in frame window", 10, 40);
	}
	
}

/**
 * 窗口适配器的监听器
 * @date 2016年9月24日
 * @author lzd
 *
 */
class MyWindowAdapter extends WindowAdapter{
	
	SampleFrame sampleFrame;
	
	public MyWindowAdapter(SampleFrame sampleFrame){
		this.sampleFrame = sampleFrame;
	}
	
	// 当点击关闭按钮的时候，就隐藏窗口
	@Override
	public void windowClosing(WindowEvent e) {
		sampleFrame.setVisible(false);
	}
}
