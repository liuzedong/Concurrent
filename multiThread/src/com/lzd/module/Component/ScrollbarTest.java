package com.lzd.module.Component;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * Scrollbar组件类的使用，就是滚动条，垂直滚动条，和横向滚动条
 * @date 2016年7月20日
 * @author lzd
 *
 */
public class ScrollbarTest implements AdjustmentListener{

	Frame f;
	Button btn;
	Panel p;
	// 创建两个滚动条对象
	Scrollbar HSB, VSB;
	// 创建坐标对象
	int x = 0, y = 0;
	
	public static void main(String[] args) {
		new ScrollbarTest();
	}
	
	public ScrollbarTest(){
		f = new Frame("滚动条的使用");
		p = new Panel(null);
		btn = new Button("按钮");
		btn.setSize(50, 20);
		btn.setLocation(x, y);
		
		// 为滚动条赋值和设置
		HSB = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 200);
		VSB = new Scrollbar(Scrollbar.VERTICAL, 0, 10, 0, 200);
		
		// 为滚动条设置事件
		HSB.addAdjustmentListener(this);
		VSB.addAdjustmentListener(this);
		
		p.add(btn);
		// 添加组件p到窗口上
		f.add(p, BorderLayout.CENTER);
		
		// 添加滚动条到窗口上
		f.add(HSB, BorderLayout.SOUTH);
		f.add(VSB, BorderLayout.EAST);
		
		
		f.setSize(250, 250);
		f.setVisible(true);
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// 获取事件的源对象
		Scrollbar sb = (Scrollbar) e.getSource();
		
		// 判断滚动条的类型
		if(sb.getOrientation() == Scrollbar.HORIZONTAL){//水平
			x = sb.getValue();
		}else {
			y = sb.getValue();
		}
		btn.setLocation(x, y);
	}
	

}
