package com.lzd.zero.samuel_morse;

import java.util.Scanner;

/**
 * 莫斯科码的
 * wo ai ni 
122 222 12 11 21 11
liu ze dong
1211 11 112 2211 1 211 222 21 221
wo bu ai wo de zhu guo le
122 222 2111 112 12 11 122 222 211 1 2211 1111 112 221 112 222 1211 1
 * @date 2016年5月27日
 * @author lzd
 *
 */
public class Samuel_Morse {
	
	public static void main(String[] args) {
		while(true){
			getMore();
		}
	}

	// 获取一串莫斯科码，然后返回编译后的文本
	public static void getMore(){
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String[] strArray = str.split(" +");
		String codeText = getCodeText(strArray);
		System.out.println(codeText);
	}
	
	// 获取你每次输入的莫斯科码
	public static void getOne(){
		while(true){
			Scanner s = new Scanner(System.in);
			String i = s.next();
			System.out.println("你输入了指令：" + i);
			getCode(i);
		}
	}
	
	// 获取一串字段传莫斯科码
	public static String getCodeText(String[] codes){
		StringBuffer strBuffer = new StringBuffer();
		String oneText = null;
		for (String code : codes) {
			oneText = getCode(code);
			strBuffer.append(oneText);
		}
		return strBuffer.toString();
	}
	
	// 判断你输入的莫斯科码
	public static String getCode(String code){
		if("12".equals(code)){
			return "A";
		}
		if("2111".equals(code)){
			return "B";
		}
		if("2121".equals(code)){
			return "C";
		}
		if("211".equals(code)){
			return "D";
		}
		
		if("1".equals(code)){
			return "E";
		}
		if("1121".equals(code)){
			return "F";
		}
		if("221".equals(code)){
			return "G";
		}
		if("1111".equals(code)){
			return "H";
		}
		if("11".equals(code)){
			return "I";
		}
		if("1222".equals(code)){
			return "J";
		}
		if("212".equals(code)){
			return "K";
		}
		if("1211".equals(code)){
			return "L";
		}
		if("22".equals(code)){
			return "M";
		}
		if("21".equals(code)){
			return "N";
		}
		if("222".equals(code)){
			return "O";
		}
		if("1221".equals(code)){
			return "P";
		}
		if("2212".equals(code)){
			return "Q";
		}
		if("121".equals(code)){
			return "R";
		}
		if("111".equals(code)){
			return "S";
		}
		if("2".equals(code)){
			return "T";
		}
		if("112".equals(code)){
			return "U";
		}
		if("1112".equals(code)){
			return "V";
		}
		if("122".equals(code)){
			return "W";
		}
		if("2112".equals(code)){
			return "X";
		}
		if("2122".equals(code)){
			return "Y";
		}
		if("2211".equals(code)){
			return "Z";
		}
		return "错误";
	}
	
}
