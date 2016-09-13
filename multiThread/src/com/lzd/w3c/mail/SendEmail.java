package com.lzd.w3c.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 发送邮件
 * @date 2016年9月13日
 * @author lzd
 *
 */
public class SendEmail {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// 收件人电子邮箱
		String to = "***@qq.com";
		
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
				return new PasswordAuthentication("***@qq.com", "密码");		// 发件人邮箱账户名称，密码
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
			message.setSubject("标题");
			
			// 设置消息体
//			message.setContent("<h1>就这个是消息的内容</h1>", "text/html;charset=gb2312");
			
			
			// 创建消息体部分
			BodyPart messageBodyPart = new MimeBodyPart();
			
			// 消息内容
			messageBodyPart.setContent("<h1>就这个是消息的内容</h1>", "text/html;charset=UTF-8");
			
			// 创建多重消息
			Multipart multipart = new MimeMultipart();
			
			// 设置消息体内容
			multipart.addBodyPart(messageBodyPart);
			
			// 附件部分
			messageBodyPart = new MimeBodyPart();
			String fileName = "/app/axtmp/pdf/2016/store/开心宝贝.pdf";
			DataSource source = new FileDataSource(fileName);
			messageBodyPart.setDataHandler(new DataHandler(source));
			// 下面 MimeUtility.encodeWord  解决中文乱码问题
			messageBodyPart.setFileName(MimeUtility.encodeWord(fileName));
			multipart.addBodyPart(messageBodyPart);
			
			
			// 发送完整的消息
			message.setContent(multipart);
			
			// 发送消息
			Transport.send(message);
			
			// 打印消息
			System.out.println(" email send successfully ");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
