package com.lzd.internet;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * 发送短信，使用jersey
 * @date 2016年8月1日
 * @author lzd
 *
 */
public class MessageClient {

	public static void main(String[] args) {
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("api", "key-官网密钥"));
		WebResource webResource = client.resource("http://sms-api.luosimao.com/v1/send.json");
		
		// 设置发送的参数
		MultivaluedMapImpl formData = new MultivaluedMapImpl();
		formData.add("mobile", "手机号");
		formData.add("message", "技术标题：java技术"+"\r\n" +"技术内容：测试【栋栋技术社】");
		ClientResponse response =  webResource.type( MediaType.APPLICATION_FORM_URLENCODED ).
				post(ClientResponse.class, formData);
		
		String textEntity = response.getEntity(String.class);
		System.out.println(textEntity + ",状态:" + response.getStatus());
	}
	
	
}
