package com.lzd.annotation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.httpclient.util.DateParseException;

import com.itextpdf.text.log.SysoCounter;

public class CalendarTest {

	public static void main(String[] args) throws DateParseException, ParseException {
		Calendar highCal = Calendar.getInstance();
		highCal.add(Calendar.DAY_OF_YEAR, -30);
//		System.out.println(c);
		
		Calendar lowCal = Calendar.getInstance();
		lowCal.add(Calendar.YEAR, -75);
		
		Calendar birthdayCal = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		Date parse = s.parse("1894-01-15");
		birthdayCal.setTime(parse);
		
		
		
		if (birthdayCal.before(lowCal) || birthdayCal.after(highCal)){
			System.out.println("身份不正确");
		}
		
		System.out.println("生日" + birthdayCal.getTime());
		System.out.println("最高" + highCal.getTime());
		System.out.println("最低" + lowCal.getTime());
		
		
		
//		System.out.println(Calendar.YEAR + "::" + Calendar.DATE);
	}
}
