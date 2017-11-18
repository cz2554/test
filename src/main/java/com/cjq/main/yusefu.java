package com.cjq.main;

import java.util.ArrayList;
import java.util.List;

public class yusefu {
		public static void main(String[] args) {
			//yuesefu(20,4);
			int f = 1, n = 20, k = 4;
			for (int i = 2; i <= n; i++) {
				f = ((f + k - 1) % i) + 1;
				System.out.println(f);
			}
				
			System.out.println(f);
		}
	 public static void yuesefu(int totalNum, int countNum) {  
			         // 初始化人数  
			         List<Integer> start = new ArrayList<Integer>();  
			         for (int i = 1; i <= totalNum; i++) {  
			             start.add(i);  
			         }  
			         //从第K个开始计数  
			         int k = 0;  
			         while (start.size() >1) {  
			            k = k + countNum;  
			             //第m人的索引位置  
			             k = k % (start.size()) - 1;  
			            // 判断是否到队尾  
		             if (k < 0) {  
			                 System.out.println(start.get(start.size()-1));  
			                 start.remove(start.size() - 1);  
			                k = 0;  
			             } else {  
			                System.out.println(start.get(k));  
			                start.remove(k);  
			             }  
			         }  
			         System.out.println(start.get(0));
			     }  
}
