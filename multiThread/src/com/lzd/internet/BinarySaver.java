package com.lzd.internet;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 从web网站下载二进制文件，并保存在本地
 * @date 2016年7月29日
 * @author lzd
 *
 */
public class BinarySaver {
	
	// 连接地址
	private static final String url = "https://4gc5nhctigyzdqptqgrhdqmmdctzdycbqcjos13diqbtzgmudp7so.ourdvsss.com/cdn00.baidupcs.com/file/4809b357f5892e07b83260ebac92f61d?bkt=p2-nb-218&xcode=fe55e08a6eb03e50300591afc645e14fa0fe8f7f11de2ca9fc7e6775e72092ed&fid=3106415542-250528-218758869655313&time=1469758965&sign=FDTAXGERLBH-DCb740ccc5511e5e8fedcff06b081203-nPHqiu%2BqBFra5tgiBUY%2B1jzdBZM%3D&to=cb00&fm=Nin,B,U,nc&sta_dx=1&sta_cs=182&sta_ft=zip&sta_ct=7&fm2=Ningbo,B,U,nc&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=14004809b357f5892e07b83260ebac92f61d7f3dbc620000000c5605&sl=79102031&expires=8h&rt=pr&r=383484770&mlogid=4880523000366257564&vuk=3106415542&vbdid=1956180142&fin=04.%5BBootstrap%5D%20%E7%AC%AC4%E7%AB%A0%20%E8%A1%A8%E5%8D%95%E5%92%8C%E5%9B%BE%E7%89%87.zip&fn=04.%5BBootstrap%5D%20%E7%AC%AC4%E7%AB%A0%20%E8%A1%A8%E5%8D%95%E5%92%8C%E5%9B%BE%E7%89%87.zip&slt=pm&uta=0&rtype=0&iv=1&isw=0&dp-logid=4880523000366257564&dp-callid=0.1.1&hps=1&wshc_tag=0&wsts_tag=579abdf5&wsid_tag=3d95fe7a&wsiphost=ipdbm";
	// 默认的编码
//	private static String encoding = "gbk";
	
	public BinarySaver(){
		try {
			URL u = new URL(url);
			saveWeb(u);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new BinarySaver();
	}


	private static void saveWeb(URL u) {
		
		// 打开链接
		try {
			URLConnection uc = u.openConnection();
			
			// web页面要求的编码集合
			String contentType = uc.getContentType();
		/*	int encodingStart = contentType.indexOf("charset=");
			if(encodingStart != -1){
				encoding = contentType.substring(encodingStart + 8);
			}*/

			// 获得，文本的长度
			int contentLength = uc.getContentLength();
			if(contentType.startsWith("text/") || contentLength == -1){
				throw new IOException("这不是一个二进制文件");
			}
			
			try(
					InputStream in = new BufferedInputStream(uc.getInputStream());
					){
				byte[] data = new byte[contentLength];
				int offset = 0;
				while (offset < contentLength){
					int byteRead = in.read(data, 0, data.length - offset);
					if (byteRead == -1){
						break;
					}
					offset += byteRead;
				}
				if (offset != contentLength){
					throw new IOException("只读到" + offset + "bytes， Expected " + contentLength + " bytes");
				}
				
				// 保存文件
				String filename = u.getFile();
				filename = filename.substring(filename.lastIndexOf("/") + 1);
				try (FileOutputStream fout = new FileOutputStream(filename)){
					fout.write(data);
					fout.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
