package com.lzd.sslsocket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

/**
 * SSL安全的服务端
 * @date 2016年8月8日
 * @author lzd
 *
 */
public class SecureOrderTaker {
	
	public final static int PORT = 7000;
	public final static String algorithm = "SSL";
	
	public static void main(String[] args) {
		try {
			SSLContext context = SSLContext.getInstance(algorithm);
			
			// 参考实现只支持X.509
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			
			// Oracle的默认密钥库类型
			KeyStore ks = KeyStore.getInstance("JKS");
			
			/**
			 * 出于安全考虑，每个密钥库都必须用口令短语加密，
			 * 在从磁盘加载前必须提供这个口令。口令短语以char[]
			 * 数组形式存储，所以可以很快从内存中擦除，而不是等待垃圾回收
			 */
			char[] password = System.console().readPassword();
			ks.load(new FileInputStream("jnp4e.keys"), password);
			kmf.init(ks, password);
			context.init(kmf.getKeyManagers(), null, null);
			
			// 擦除口令
			Arrays.fill(password, '0');
			SSLServerSocketFactory factory = context.getServerSocketFactory();
			
			SSLServerSocket server = (SSLServerSocket) factory.createServerSocket(PORT);
			
			// 增加匿名(未认证)密码组
			String[] supported = server.getSupportedCipherSuites();
			String[] anonCipherSuitesSupported = new String[supported.length];
			int numAnonCipherSuitesSupported = 0;
			for (int i = 0; i < supported.length; i++) {
				if(supported[i].indexOf("_anon_") > 0){
					anonCipherSuitesSupported[numAnonCipherSuitesSupported++] = supported[i];
				}
			}
			
			String[] oldEnabled = server.getEnabledCipherSuites();
			String[] newEnabled = new String[oldEnabled.length + numAnonCipherSuitesSupported];
			
			System.arraycopy(oldEnabled, 0, newEnabled, 0, oldEnabled.length);
			System.arraycopy(anonCipherSuitesSupported, 0, newEnabled, oldEnabled.length, numAnonCipherSuitesSupported);
			
			server.setEnabledCipherSuites(newEnabled);
			
			// 现在所有设置工作已经完成，
			// 可以集中进行实际通信勒
			while(true){
				// 这个socket是安全的
				// 但是从代码中看不出来任何痕迹
				try(Socket theConnection = server.accept()){
					InputStream in = theConnection.getInputStream();
					int c;
					while((c = in.read()) != -1){
						System.out.write(c);
					}
				}
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
	}

}
