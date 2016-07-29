package com.lzd.internet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载由口令保护的web页面程序
 * @date 2016年7月28日
 * @author lzd
 *
 */
public class SecureSourceViewer {

	public static void main(String[] args) {
		Authenticator.setDefault(new DialogAuthenticator());
		
		for (int i = 0; i < args.length; i++) {
			try {
				URL u = new URL(args[i]);
				try(InputStream in = new BufferedInputStream(u.openStream())){
					// 将InputStream 串联到一个Reader
					Reader r = new InputStreamReader(in);
					int c ;
					while((c = r.read()) != -1){
						System.out.print((char) c);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			// 打印一个换行，以隔开页面
			System.out.println();
		}
		
		// 由于使用ATW，所以显式退出
		System.exit(0);
	}
}
