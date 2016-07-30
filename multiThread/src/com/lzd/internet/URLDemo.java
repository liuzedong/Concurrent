package com.lzd.internet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

/**
 * URL类的使用示例
 * @date 2016年7月27日
 * @author lzd
 *
 */
public class URLDemo {
	
	/**
	 * 根据流获取数据，直接打印再控制台
	 * @author 刘泽栋 2016年7月27日 下午4:48:33
	 */
	@Test
	public void getHostContent(){
		try {
			// 创建URL
			URL u = new URL("http://www.jb51.com");
			// 打开链接，过去结果
			try(
					InputStream in = u.openStream();
					BufferedInputStream bin = new BufferedInputStream(in);
					){
				// 把流中的结果，打印到控制台
				byte[] b = new byte[1024];
				while(bin.read(b) != -1){
					System.out.println(new String(b, "GBK"));
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println("java不支持该协议");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据，打印在控制台
	 * @author 刘泽栋 2016年7月27日 下午4:49:02
	 */
	@Test
	public void downloadHtml(){
		String[] args = new String[]{"http://www.jb51.com"};
		if(args.length > 0){
			InputStream in = null;
			try {
				// 打开URL进行读取文件
				URL u = new URL(args[0]);
				in = u.openStream();
				
				// 缓存输入以提交性能
				in = new BufferedInputStream(in);
				// 将InputStream串联到Reader上
				Reader r = new InputStreamReader(in);
				
				int c;
				while((c = r.read()) != -1){
					System.out.print((char)c);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				// 关闭流
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	/**
	 * 打开链接返回一个对象，
	 * 如果是图片，返回一个图片对象，如果是一个电影，返回一个电影的对象，
	 * 这些对象，很难确认返回的对象
	 * @author 刘泽栋 2016年7月27日 下午4:50:17
	 */
	@Test
	public void contentGetter(){
		String[] args = new String[]{"http://s3.51cto.com/wyfs02/M02/7F/A3/wKioL1cnJfjg0k3XAAGGTjX8Gbo267.png",
				"ftp://ygdy8:ygdy8@y153.dydytt.net:9095/[阳光电影www.ygdy8.com].曼哈顿夜曲.BD.720p.中英双字幕.rmvb"};
		if(args.length > 0){
			try {
				URL u = new URL(args[0]);
				// 获取对象，如果是图片的话，返回的会是一个JPG对象的
				Object o = u.getContent();
				System.out.println("返回的对象" + o.getClass().getName());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 分解URL，获取URL中的信息
	 * @author 刘泽栋 2016年7月27日 下午5:11:52
	 */
	@Test
	public void getURLisGetMesg(){
		try {
			URL u = new URL("http://s3.51cto.com/wyfs02/M02/7F/A3/wKioL1cnJfjg0k3XAAGGTjX8Gbo267.png");
			
			System.out.println("默认端口号：" + u.getDefaultPort());
			System.out.println("URL的文件名称：" + u.getFile());
			System.out.println("URL的主机名称：" + u.getHost());
			System.out.println("URL路径部分：" + u.getPath());
			// URL中没有明确指定端口，显示-1
			System.out.println("端口号：" + u.getPort());
			System.out.println("UR的协议：" + u.getProtocol());
			// ? 后面
			System.out.println("URL的查询部分：" + u.getQuery());
			// # 后面
			System.out.println("URL的锚点：" + u.getRef());
			// liudong@192.168.1.12 这个前面的liudong
			System.out.println("URL的userInfo：" + u.getUserInfo());
			System.out.println("URL授权部分：" + u.getAuthority());
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
