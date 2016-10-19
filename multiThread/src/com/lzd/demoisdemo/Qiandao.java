package com.lzd.demoisdemo;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 签到Demo
 * @date 2016年10月13日
 * @author lzd
 *
 */
public class Qiandao {
	
	private final static String URLSTR = "http://www.18bg.com//check/signin";
	
	private final static String REQUESTMETHOD = "POST";
	
	public static void main(String[] args) throws Exception {
		URL url = new URL(URLSTR);
		
		HttpURLConnection openUrl = (HttpURLConnection) url.openConnection();
		openUrl.setDoOutput(true);
		openUrl.setRequestMethod(REQUESTMETHOD);
		
		OutputStream out = openUrl.getOutputStream();
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("isWeb", "true");
		map.put("auth", "authentication D3F90A2BC949274C959B9B9BCFBF7299");
		String par = getParMessage(map);
		System.out.println("入参数结果 : " + par);
		
		
		
		out.write(par.getBytes());
		out.close();
		openUrl.getInputStream();
//		openUrl.connect();
		
		/*InputStream in = openUrl.getInputStream();
		
		Reader reader = new InputStreamReader(in);
		LineNumberReader r = new LineNumberReader(reader);
		
		
		// 读取数据
		while (r.ready()){
			System.out.println(r.readLine());
		}*/
		

		
		
	}

	// 拼接参数
	private static String getParMessage(Map<String, String> map) {
		StringBuilder param = new StringBuilder();
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			param.append(key).append("=").append(map.get(key)).append("&");
		}
		
		return param.substring(0, param.length() - 1);
	}

}
