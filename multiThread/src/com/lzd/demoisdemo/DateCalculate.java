package com.lzd.demoisdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java切割日期时间代码段
 * @date 2016年9月19日
 * @author lzd
 *
 */
public class DateCalculate {
	
	private static final Logger log = Logger.getLogger(DateCalculate.class.getCanonicalName());
	
	/**
	 * 
	 * @param dateType
	 * @param start
	 * @param end
	 * @return
	 * @author 刘泽栋 2016年9月19日 下午5:13:01
	 */
	public static List<String> cutDate(String dateType, String start, String end){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dBegin = sdf.parse(start);
			Date dEnd = sdf.parse(end);
			return findDates(dateType, dBegin, dEnd);
		} catch (ParseException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

	private static List<String> findDates(String dateType, Date dBegin,
			Date dEnd) {
		List<String> listDate = new ArrayList<String>();
		
		
		// 开始时间
		Calendar calBegin = Calendar.getInstance();
		calBegin.setTime(dBegin);
		// 结束时间
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(dEnd);
		
		while(calEnd.after(calBegin)){
			switch (dateType){
				case "M" : 
					calBegin.add(Calendar.MONTH, 1);
					break;
				case "D" :
					calBegin.add(Calendar.DAY_OF_YEAR, 1);
					break;
				case "H" :
					calBegin.add(Calendar.HOUR, 1);
					break;
				case "N" :
					calBegin.add(Calendar.SECOND, 1);
					break;
			}
			if (calEnd.after(calBegin)){
				listDate.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calBegin.getTime()));
			}else {
				listDate.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calEnd.getTime()));
			}
		}
		return listDate;
	}

	public static void main(String[] args) {
		 String start = "2016-02-01 00:00:00";
		 String end = "2016-03-02 00:00:00";
		 List<String> cutDate = cutDate("M", start, end);
		 for (String str: cutDate) {
			System.out.println(str);
		}
	}
	
	
}
