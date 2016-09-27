package com.lzd.eventAction.menu;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 获取文件的对话框，标准对话框
 * @date 2016年9月27日
 * @author lzd
 *
 */
public class FileDialogDemo {

	
	public static void main(String[] args) {
		Frame f = new SampleFrame("文本对话框");
		f.setVisible(true);
		f.setSize(100, 100);
		
		FileDialog fd = new FileDialog(f, "File Dialog");
		fd.setVisible(true);
		
		System.out.println("文件名：" + fd.getFile());
		System.out.println("文件目录：" + fd.getDirectory());
		
	}
	
}

class  SampleFrame extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SampleFrame(String title) {
		super(title);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			 
		});
		
	}
}
