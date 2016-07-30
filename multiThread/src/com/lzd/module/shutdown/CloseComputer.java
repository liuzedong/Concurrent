package com.lzd.module.shutdown;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 关机的页面，继承JFrame类，就可以使用GUI啦，实现ActionListener就可以实现事件的监听
 * @date 2016年7月18日
 * @author lzd
 *
 */
public class CloseComputer extends JFrame implements ActionListener{
	
	/**
	 * 序列化字段
	 */
	private static final long serialVersionUID = 1L;
	
	// 创建成员变量
	// 创建实现BorderLayout布局的面板对象panel_main
	private JPanel panel_main = new JPanel(new BorderLayout(5, 10));
	
	// 创建实现FlowLayout布局的面板对象panel_subnorth
	private JPanel panel_subnorth = new JPanel(new FlowLayout(3));
	
	// 创建实现FlowLayout布局的面板对象panel_subcenter
	private JPanel panel_subcenter = new JPanel(new FlowLayout(1, 5, 5));
	
	// 创建三个按钮对象countdown, time和cancel
	private JButton countdown = new JButton("倒计时关机");
	private JButton time = new JButton("定时关机");
	private JButton cancel = new JButton("取消关机");
	
	
	private JLabel tag;	// 创建标签对象tag
	String key; 	// 创建字符串对象key
	
	
	// 构造函数
	public CloseComputer() {
		// 添加对象panel_main到主窗口中
		this.getContentPane().add(panel_main);
		// 添加对象panel_subnorth到对象panel_main窗口中
		panel_main.add(panel_subnorth, BorderLayout.NORTH);
		// 添加对象panel_subcenter到对象panel_main窗口中
		panel_main.add(panel_subcenter, BorderLayout.CENTER);
		
		// 添加标签对象tag到对象panel_subnorth里
		panel_subnorth.add(tag = new JLabel("请选择关机方式:"));
		
		// 添加三个按钮到panel_subcenter里面
		panel_subcenter.add(countdown);
		panel_subcenter.add(time);
		panel_subcenter.add(cancel);
		
		// 为三个按钮注册时间监听器
		countdown.addActionListener(this);
		time.addActionListener(this);
		cancel.addActionListener(this);
	}

	
	// 主方法
	public static void main(String[] args) {
		// 创建CloseComputer对象
		CloseComputer frame = new CloseComputer(); 
		
		// 设置窗口关闭功能
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		// 设置窗口的大小
		frame.setSize(320, 120);
		// 设置标题
		frame.setTitle("关机工具");
		frame.setLocation(350, 350);
		
		// 设置显示
		frame.setVisible(true);
		frame.setResizable(false);
	}

	
	// "倒计时关机"，调用的方法
	public void countdown() {
		// 获取输入的信息
		key = JOptionPane.showInputDialog(this, "请输入倒计时关机剩余的时间(秒)", "输入框", 1);
//		CountTimeTool.delaytime(Long.parseLong(key));
		
	}
	
	// "定时关机"调用的方法
	public void time() {
		// 获取当前系统的时间
		Calendar calendar = Calendar.getInstance();
		// 获取当前的时，分，秒
		int h = calendar.get(Calendar.HOUR);
		int m = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);
		
		// 转换变量h为字符串
		String a = String.valueOf(h);
		// 定义输入的时，分，秒int类型变量
		int hour, minute, secord;
		// 定义输入的时，分，秒Stirng类型的变量
		String hourtmp, minutetmp, secordtmp;
		
		// 为变量hourtmp, minutetmp, secordtmp 赋值
		hourtmp = JOptionPane.showInputDialog(this, "请输入关闭的时间(12小时)", "输入", 1);
		minutetmp = JOptionPane.showInputDialog(this, "请输入关闭的分钟", "输入", 1);
		secordtmp = JOptionPane.showInputDialog(this, "请输入关闭的秒钟", "输入", 1);
		
		// 把String类型变量转换称int类型变量
		hour = Integer.parseInt(hourtmp);
		minute = Integer.parseInt(minutetmp);
		secord =  Integer.parseInt(secordtmp);
		
		// 通过调用timesum()方法，计算出当前系统的时间currently_time和输入的时间set_time
		long set_time = timesum(hour, minute, secord);
		long currently_time = timesum(h, m, s);
		
		
		// 获取设置时间与系统时间之间的差
		long discrepancy_time = set_time - currently_time;
		
		// 当设置时间比系统时间早时，执行关机
		if(discrepancy_time < 0){
			try{
				// 执行关闭功能
				Runtime.getRuntime().exec("shutdown -h now");
			}catch(IOException e){
				e.printStackTrace();
			}
		}else {
			// 如果 比当前系统时间晚，
//			CountTimeTool.delaytime(discrepancy_time);
			JOptionPane.showMessageDialog(this, "恭喜你，设置成功", "确认", 2);
		}
		
	}
	
	// 计算出时间的总和，然后返回
	private long timesum(int hour, int minute, int secord) {
		int sum = hour * 3600 + minute * 60 + secord;
		return sum;
	}


	// "取消关机"调用的方法
	public void cancel() {
		JOptionPane.showMessageDialog(this, "你已经成功取消了关机操作", "消息", 2);
		try {
			Runtime.getRuntime().exec("shutdown -a");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 监听事件
	@Override
	public void actionPerformed(ActionEvent e) {
		String ActionCommand = e.getActionCommand();
		if(e.getSource() instanceof JButton){
			if ("倒计时关机".endsWith(ActionCommand)){
				countdown();
			}
			if ("定时关机".endsWith(ActionCommand)){
				time();
			}
			if ("取消关机".endsWith(ActionCommand)){
				cancel();
			}
		}
	}



}
