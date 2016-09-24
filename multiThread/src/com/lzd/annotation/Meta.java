package com.lzd.annotation;

import java.lang.reflect.Method;

/**
 * 使用反射获取注解上的信息
 * @date 2016年9月18日
 * @author lzd
 *
 */
public class Meta {
	
	@MyAnno(str = "Annotation Example", val = 100)
	public static void myMeth(){
		Meta ob = new Meta();
		
		Class<?> c = ob.getClass();
		try {
			// 使用反射获取，Meta类中的myMeth方法
			Method m = c.getMethod("myMeth");
			
			// 获取方法上面的注解，里面传入的参数是，注解的对象
			MyAnno anno = m.getAnnotation(MyAnno.class);
			
			// 获取注解对象后，然后打印他们的值吧
			System.out.println(anno.str() + ":" + anno.val());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 主方法，进行调用测试
	 * @param args
	 * @author 刘泽栋 2016年9月18日 上午11:27:34
	 */
	public static void main(String[] args) {
//		myMeth();
		getMyMethod();
	}
	
	
	// 获得MyMethod类中的方法，上面的注解
	public static void getMyMethod(){
		Method m;
		try {
			m = MyMethod.class.getMethod("method");
			MyAnno myanno = m.getAnnotation(MyAnno.class);
			
			System.out.println(myanno.str() + ":" + myanno.val());
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
}