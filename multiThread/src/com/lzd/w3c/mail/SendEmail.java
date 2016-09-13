package com.lzd.w3c.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件
 * @date 2016年9月13日
 * @author lzd
 *
 */
public class SendEmail {

	public static void main(String[] args) {
		// 收件人电子邮箱
		String to = "***.qq.com";
		
		// 发件人电子邮箱
		String from = "***@qq.com";
		
		// 指定发件人的主机为 smtp.qq.com
		String host = "smtp.qq.com";
		
		// 获取系统属性
		Properties properties = System.getProperties();
		
		// 设置邮箱服务器
		properties.setProperty("mail.smtp.host", host);
		
		properties.put("mail.smtp.auth", "true");
		
		// 获得session对象
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("账户", "密码");		// 发件人邮箱账户名称，密码
			}
		});
		
		// 创建默认的MimeMessage对象
		MimeMessage message = new MimeMessage(session);
		
		try {
			// Set From：头对象
			message.setFrom(new InternetAddress(from));
			
			// Set To : 头对象
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			// Set Subject : 头对象
			message.setSubject("这个是消息头");
			
			// 设置消息体
			message.setText("这个消息的内容");
			
			// 发送消息
			Transport.send(message);
			
			// 打印消息
			System.out.println(" email send successfully ");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
