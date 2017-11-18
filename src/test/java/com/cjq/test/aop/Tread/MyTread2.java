package com.cjq.test.aop.Tread;

import static org.junit.Assume.assumeNoException;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class MyTread2  extends Thread {
	static volatile int i=0;
	static volatile int j=0;
	static  Boolean b=true;
	static  Boolean c=true;
	static ReentrantLock lock=new ReentrantLock();
	public static  void method1() {
		
			try {
				sleep(100);
				method2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				System.out.println(Thread.currentThread().getName()+"i:"+i++);
			
			
		}
		
		
	}
	public static  void method2() {
		
		try {
			sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		finally {
			System.out.println(Thread.currentThread().getName()+"j:"+j++);
	
		}
		
	}
	@Override
	public void run() {
		try {
			i++;
			sleep(100);
			j++;
			//method1();
			//method2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//ExecutorService  pool = Executors.newCachedThreadPool();
		ExecutorService  pool = Executors.newFixedThreadPool(5);
		MyTread2 mythread=null;
		for(int i=0;i<10;i++) {
			 mythread=new MyTread2();
			//mythread.start();
		
			pool.execute(mythread);
		}
		pool.shutdown();
		while(true) {
			if(pool.isTerminated()){  
				System.out.println(MyTread2.j);
				break;
			}
			
		}
	}
}
