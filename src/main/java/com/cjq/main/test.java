package com.cjq.main;

import com.cjq.test.GoodsVo;

public class test {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		GoodsVo good=new GoodsVo();
//			good.name="123";
			//System.out.println(good.name);
//			System.out.println("我的第一个分支");
//			System.out.println(123);
	try {
		test();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
				
		
	}

	public static void test() throws Exception {
             if(1==1)throw new Exception("1=2为fasle"); 
	}
	
}
