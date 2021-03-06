package com.cjq.test;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;



public class Test2 {

	static public  void main(String[] args) throws ParseException {
	String a="222.0";
	System.out.println(Double.valueOf(a).intValue());
		// TODO Auto-generated method stub
		HashSet<String> set=new HashSet<String>(4);
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("A");
		set.add("D");
//		set.add("E");
		set.add("F");
		set.add("G");
		Iterator<String> iter=set.iterator();
		
		for(;iter.hasNext();) {
			System.out.println(iter.next());
		}
		System.out.println(set.size());
		
		LinkedList<String> list=new LinkedList<String>();
		//list.add("15");

		System.out.println(list.size());
		Integer i=5555;
		String s="1300639306";
		System.out.println(s.replace("06", ""));
		System.out.println(s.replaceAll("06", ""));
		Date date=new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr=format.format(date);
		
		System.out.println(date.getDate());
		date.setDate(date.getDate()+2);
		System.out.println(date.getDate());
		System.out.println(date);
		try {
			date=format.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//字符串转换成日期
		ParsePosition pos = new ParsePosition(0); 
		date=format.parse(dateStr, pos); 
		try {
			Date date2=format.parse(dateStr);
			System.out.println(date2.toString());
			String dateStr1="2017/22/02";
			dateStr1=parseDate(dateStr1);
			System.out.println(dateStr1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date.toString());
		
		
	}
    public static String parseDate(String dateStr) throws Exception {
    	int length=dateStr.length();
    	SimpleDateFormat   dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    	dateFormat.setLenient(false);

    	if(length==8) {
    		dateStr=dateStr.substring(0, 4)+'/'+dateStr.substring(4,6)+"/"+dateStr.substring(6,8);
    	}else if(length==10) {
    		if(dateStr.indexOf("-")>0) {
    			dateStr=dateStr.replace("-", "/");
    		}
    	}else {
    		throw new Exception("日期格式错误");
    	}
    	dateFormat.parse(dateStr);

    	return dateStr;
    }
}
