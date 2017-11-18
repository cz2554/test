package com.cjq.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteText {
	final String path="D:/";
public static void main(String[] args) {
	test();
	File file=new File("D:\\test.txt");
	List list=txt2String(file);

}
public static void test(){
	try  
	
	{      
        FileWriter fw = new FileWriter("D:\\demo1.txt",false);  
        /** 
         * 调用该对象的write方法，向文件写入字符。 
         *  
         * 其实写入到了临时存储缓冲区中 
         */  
//      fw.write("hello \r\nworld!");//windows中的换行为\r\n    unix下为\r。  
        StringBuffer stbuffer=new StringBuffer();
        stbuffer.append("select * from a where 1=2 \r\n");
        stbuffer.append("select * from b where 1=2");
        fw.write(stbuffer.toString().toCharArray());    
        /** 
         * 进行刷新，将字符写到目的地中。 
         */  
//      fw.flush();  
        /** 
         * 关闭流，关闭资源。在关闭前会调用flush方法 刷新缓冲区。关闭后在写的话，会抛IOException 
         */  
        fw.close();  
	  }  
	  catch (IOException e)  
	  {  
	    //  
	    e.printStackTrace();  
	  }
	}
public static List<String[]> txt2String(File file){
	List<String[]> list=new ArrayList<String[]>();
    StringBuilder result = new StringBuilder();
    try{
        BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
        String s = null;
        String[] s1=null;
        int i=0;
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
        	if(i>0) {
        		s1=s.split(" ");
        		list.add(s1);
        	}
            i++;
        }
        br.close();    
    }catch(Exception e){
        e.printStackTrace();
    }
    return list;
}
}
