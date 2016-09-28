package com.lzd.eventAction.image;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

/**
 * 加载以幻灯片方式显示三张图片，并且显示优美的加载进度条
 * 主要使用MediaTracker 这个类，用来跟踪图片的信息
 * @date 2016年9月28日
 * @author lzd
 *
 */
public class TrackedImageLoad extends Applet implements Runnable{

	private static final long serialVersionUID = 1L;

	MediaTracker tracker;
	int  tracked;
	int frame_rate = 5;
	int current_img = 0;
	Thread motor;
	static final int MAXIMAGES = 10;
	Image[] img = new Image[MAXIMAGES];
	String[] name = new String[MAXIMAGES];
	volatile boolean stopFlag;
	
	
	@Override
	public void init() {
		System.out.println(getDocumentBase());
		// 初始化变量
		tracker = new MediaTracker(this);
		// 分割字符
		StringTokenizer st = new StringTokenizer("Lilites+SunFlower+ConeFlowers", "+");
		while(st.hasMoreTokens() && tracked <= MAXIMAGES){
			name[tracked] = st.nextToken();
			try {
				img[tracked] = getImage(new URL("file:/home/liuzedong/git/Concurrent/multiThread/src/com/lzd/eventAction/image/"), name[tracked] + ".jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tracker.addImage(img[tracked], tracked);
			tracked++;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		String loaded = "";
		int donecount = 0;
		
		for (int i = 0; i < tracked; i++) {
			if (tracker.checkID(i, true)){
				donecount++;
				loaded += name[i] + " ";
			}
		}
		
		Dimension d = getSize();
		int w = d.width;
		int h = d.height;
		
		if (donecount == tracked){
			frame_rate = 1;
			Image i = img[current_img++];
			int iw = i.getWidth(null);
			int ih = i.getHeight(null);
			g.drawImage(i, (w - iw)/2, (h - ih)/2, null);
			if (current_img >= tracked){
				current_img = 0;
			}else {
				int x = w*donecount/tracked;
				g.setColor(Color.black);
				g.fillRect(0, h/3, x, 16);
				g.setColor(Color.white);
				g.fillRect(x, h/3, w-x, 16);
				g.setColor(Color.black);
				g.drawString(loaded, 10, h/2);
			}
		}
	}
	
	@Override
	public void start() {
		motor = new Thread(this);
		stopFlag = false;
		motor.start();
	}
	
	@Override
	public void stop() {
		stopFlag = true;
	}
	
	@Override
	public void run() {
		motor.setPriority(Thread.MIN_PRIORITY);
		while (true){
			repaint();
			try {
				Thread.sleep(5000/frame_rate);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
				return ;
			}
			if (stopFlag){
				return ;
			}
		}
	}

}
