package com.lzd.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * 在运行是创建的注解
 * 因此，在程序执行期间通过JVM可以获取MyAnno
 * 如果没有指定RetentionPolicy.RUNTIME，使用反射的话，是会报错的
 * @date 2016年9月18日
 * @author lzd
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
	String str();
	int val();
}
