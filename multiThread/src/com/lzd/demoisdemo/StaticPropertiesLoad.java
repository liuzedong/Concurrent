package com.lzd.demoisdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 静态获取文件
 * @date 2016年8月25日
 * @author lzd
 *
 */
public class StaticPropertiesLoad {
	
	private static final Logger log = Logger.getLogger(StaticPropertiesLoad.class.getCanonicalName());
	private static final String urlPropertis;
	private static final Properties ps = new Properties();
	
	static {
		urlPropertis = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "dir/properties/url.properties";
		try {
			ps.load(Files.newInputStream(Paths.get(urlPropertis)));
		} catch (IOException e) {
			log.log(Level.WARNING, "文件没有找到。。。。", e);
		}
	}
	
	private StaticPropertiesLoad(){	}

	/**
	 * 获取urlProperties文件
	 * @return
	 * @author 刘泽栋 2016年8月25日 下午7:07:43
	 */
	public static String getUrlPropertis(){
		return urlPropertis;
	}

	public static Object getValue(String key){
		return ps.get(key);
	}
	
}
