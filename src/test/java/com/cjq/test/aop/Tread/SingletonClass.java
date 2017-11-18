package com.cjq.test.aop.Tread;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class SingletonClass {

	@Test
	 public void runaaa(Map<String,String> a) {


			  
			 String k=a.get("0").toString();
			 int m=1;
			 System.out.println("程序开始"+k);
			 for(int j=0;j<1000000000;j++) {
				 m=m%10*m;
			 }
			 System.out.println("程序结束"+k);
		
		 
		List list=null;
		System.out.println(list.isEmpty());
	 }
}
