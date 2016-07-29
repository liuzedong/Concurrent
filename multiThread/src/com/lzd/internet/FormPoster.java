package com.lzd.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * 使用URLConnetion 提交一个表单
 * @date 2016年7月29日
 * @author lzd
 *
 */
public class FormPoster {
	
	private URL url;
	
	private QueryString query = new QueryString();
	
	public FormPoster(URL url){
		if(!url.getProtocol().toLowerCase().startsWith("http")){
			throw new IllegalArgumentException("posting only works for http URLs");
		}
		this.url = url;
	}

	public void add(String name, String value){
		query.add(name, value);
	}
	
	public URL getURL(){
		return this.url;
	}
	
	public InputStream post() throws IOException {
		// 打开链接，准备POST
		URLConnection uc = url.openConnection();
		// 设置为可以发送post请求
		uc.setDoOutput(true);
		
		try(OutputStreamWriter out = new OutputStreamWriter(uc.getOutputStream(), "UTF-8")){
			// POST行，Content-type首部和Content-length首部
			// 由URLConnection发送
			// 我们只需要发送数据
			out.write(query.toString());
//			out.write("\r\n");
			out.flush();
		}
		
		// 返回响应
		return uc.getInputStream();
	}
	
	// 解析相关数据
	public String resolve(String data){
		@SuppressWarnings("unchecked")
		Map<String, JSONArray> map = (Map<String, JSONArray>) JSON.parse(data);
	
		return	map.get("trans_result").getJSONObject(0).get("dst").toString();
	}
	
	// 获取百度翻译的API
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://api.fanyi.baidu.com/api/trans/vip/translate");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		FormPoster poster = new FormPoster(url);
		poster.add("q", "Apache Commons is an Apache project focused on all aspects of reusable Java components. ");
		poster.add("from", "en");
		poster.add("to", "zh");
		poster.add("appid", "20160729000025992");
		poster.add("salt", "1435660288");
		
		String sign = "20160729000025992" + "Apache Commons is an Apache project focused on all aspects of reusable Java components. " + "1435660288" + "_wvFZHCp4mMwZ2xvPJGe";
		sign = DigestUtils.md5Hex(sign);
		poster.add("sign", sign);
		
		try(InputStream in = poster.post();){
			// 读取相应
			Reader r = new InputStreamReader(in);
			StringBuffer data = new StringBuffer();
			int c;
			while((c = r.read()) != -1){
				data.append((char) c);
			}
//			System.out.println(data.toString());
			String dst = poster.resolve(data.toString());
			System.out.println("返回的信息：" + dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
