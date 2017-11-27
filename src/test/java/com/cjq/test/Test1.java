package com.cjq.test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.fasterxml.jackson.databind.ser.std.IterableSerializer;

import redis.clients.jedis.Jedis;

public class Test1 {
	public static void main(String[] args) {
		byte [] bye=new byte[1000];
		String s=bye.toString();
		try {
			s.getBytes("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataInputStream dataInputStream=new DataInputStream(new InputStream() {
			
			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		GoodsVo good=new GoodsVo();
 good.name="123";
 System.out.println(good.name);
//System.out.println("a"=="a");
List list=null;
//System.out.println(list.isEmpty());
String a="a";
try {
  a.equals("a");

} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	throw e;
}
System.out.println(123);
	}

	@Test
	public  void test() throws Exception {
		System.out.println(123);
		String c="abc";
		String m="a";
		String  b="a"+"bc";
		System.out.println(c==b);
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(null);
		set1.add(123);
		Iterator<Integer> a = set1.iterator();
		for (; a.hasNext();) {
			System.out.println(a.next());
		}
		Map map = new HashMap();
		List list=null;
		System.out.println(list.isEmpty());
	}
	

	@Test
	public void testRedis() {
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully");
		jedis.lpush("tutorial-list", "Redis");
		jedis.lpush("tutorial-list", "Mongodb");
		jedis.lpush("tutorial-list", "Mysql");
		List<String> list = jedis.lrange("tutorial-list", 0, 5);

		for (int i = 0; i < list.size(); i++) {
			System.out.println("Stored string in redis:: " + list.get(i));
		}
	}

	@Test
	public void Goods() {
		Jedis jedis = new Jedis("localhost");
		GoodsVo goods = new GoodsVo();
		goods.setName("苹果");
		goods.setPrice("5元");
		goods.setNumber("100个");
		jedis.set("good".getBytes(), SerializeUtil.serialize(goods));
		GoodsVo good1 = (GoodsVo) SerializeUtil.unserialize(jedis.get("good".getBytes()));
		System.out.println(good1.getName());
		String a = "abcsadasdasdasdasdasdasdas";
		String b = a;
		System.out.println(a == b);

		for (int i = 2; i < 5;) {

		}
		
	}

	@Test
	public void Sort() {
		long q = System.currentTimeMillis();
		int[] a = { 1, 3, 5, 7, 9 };
		int[] b = { 8,4};
		int[] c = new int[a.length + b.length];
	
		
		
		//long k = System.currentTimeMillis();
		//System.out.println(k - q);

	
			c=sort(a, b);
			for(int y=0;y<c.length;y++) {
				System.out.println(c[y]);
			}
		long l = System.currentTimeMillis();
		//System.out.println(l - k);
	}

	public static int[] sort(int[] a, int[] b) {// a,b数组必须有序
		int merge[] = new int[a.length + b.length];
		int lenA = 0, lenB = 0, lenMer = 0;
		while (lenA < a.length && lenB < b.length) {
			if (a[lenA] < b[lenB]) {
				merge[lenMer++] = a[lenA++];
			} else {
				merge[lenMer++] = b[lenB++];
			}
		}
		while (lenA < a.length) {
			merge[lenMer++] = a[lenA++];
		}

		while (lenB < b.length) {
			merge[lenMer++] = b[lenB++];
		}
		return merge;
	}

}
