package com.lzd.internet;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * 一个GUI认证程序
 * @date 2016年7月28日
 * @author lzd
 *
 */
public class DialogAuthenticator extends Authenticator {
	
	private JDialog passwordDoalog;
	// 用户名的文本输入框
	private JTextField usernameField = new JTextField(20);
	// 密码输入框
	private JPasswordField passwordField = new JPasswordField(20);
	private JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("cancel");
	private JLabel mainLabel = new JLabel("Please enter username and password");
	
	
	
	public DialogAuthenticator(){
		this("", new JFrame());
	}
	
	public DialogAuthenticator(String username){
		this(username, new JFrame());
	}
	
	public DialogAuthenticator(JFrame frame){
		this("", frame);
	}
	
	public DialogAuthenticator(String username, JFrame parent){
		this.passwordDoalog = new JDialog(parent, true);
		Container pane = passwordDoalog.getContentPane();
		pane.setLayout(new GridLayout(4, 1));
		
		// 把组件添加到面板中
		JLabel userLabel = new JLabel("Username");
		JLabel passwordLabel = new JLabel("Password");
		pane.add(mainLabel);
		JPanel p2 = new JPanel();
		p2.add(userLabel);
		p2.add(usernameField);
		usernameField.setText(username);
		pane.add(p2);
		JPanel p3 = new JPanel();
		p3.add(passwordLabel);
		p3.add(passwordField);
		pane.add(p3);
		JPanel p4 = new JPanel();
		p4.add(okButton);
		p4.add(cancelButton);
		pane.add(p4);
		passwordDoalog.pack();
		
		ActionListener al = new OKResponse();
		okButton.addActionListener(al);
		usernameField.addActionListener(al);
		passwordField.addActionListener(al);
		cancelButton.addActionListener(new CancelResponse());
	}
	
	private void show(){
		String prompt = this.getRequestingPrompt();
		if(prompt == null){
			String site = this.getRequestingSite().getHostName();
			String protocol = this.getRequestingProtocol();
			int port = this.getRequestingPort();
			if(site != null && protocol != null){
				prompt = protocol + "://" + site;
				if (port > 0) prompt += ":" + port;
			}else {
				prompt = "";
			}
		}
		
		mainLabel.setText("Please enter username and password for " + prompt + ": ");
		passwordDoalog.pack();
		passwordDoalog.setVisible(true);
	}
	
	PasswordAuthentication response = null;
	
	class OKResponse implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			passwordDoalog.setVisible(false);
			// 出于安全原因，
			// 口令作为char数组返回
			char[] password = passwordField.getPassword();
			String username = usernameField.getText();
			// 清楚口令，以防再次使用
			passwordField.setText("");
			response = new PasswordAuthentication(username, password);
			
			
		}
	}
	
	class CancelResponse implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			passwordDoalog.setVisible(false);
			// 清除口令，以防再次使用
			passwordField.setText("");
			response = null;
		}
	}
	
	public PasswordAuthentication getPasswordAuthentication(){
		this.show();
		return response;
	}
}
