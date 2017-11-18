package com.cjq.test.Except;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

public class ExceptTest {
	public static void main(String[] args) {
	String a=null;
	List list=new ArrayList<Integer>();
	int k=10;
	Integer m=4566;
	list.add(k);
	m.valueOf("455");
	System.out.println(list.get(0));
		try {
		// if(a.equals("aaa"))System.out.println("true");
		 InputStream i=new FileInputStream(new File("D://123"));
		 System.out.println(i.read());
		 i.close();
		} catch (Exception e) {
			//e.printStackTrace();
		}finally {
			System.out.println(123);
		}
	
		System.out.println(4564);
}
}
