package com.cjq.test.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
				try {
					Class<?> cla=Class.forName("com.cjq.test.invoke.Employee");
					Constructor<?> c1 = cla.getDeclaredConstructor();
					c1.setAccessible(true);
					Object employee= c1.newInstance();
					
					Field[] fields=cla.getDeclaredFields();
					Method method= cla.getMethod("system", String.class,String.class);
					method.invoke(employee, "1223","45665");
					for(int i=0;i<fields.length;i++) {
						System.out.println(fields[i].getName());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
