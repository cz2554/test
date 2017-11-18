package com.cjq.test.aop.Tread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
	private static Integer a = 0;
	private static Integer b = 0;
	private static Integer c = 0;
	private Boolean bool = true;
	private String filename;
	static ReentrantLock lock = new ReentrantLock();

	MyThread(String filename) {
		this.filename = filename;
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		try {
			sleep(1000);
			lock.lock();
				a++;
				b++;
			lock.unlock();
		System.out.println("this :" + c + "----" + this.getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (bool) {
				c--;

			}
		}

	}

	public static void main(String[] args) {
		List<MyThread> list = new ArrayList<MyThread>();
		for (int i = 0; i < 100; i++) {
			MyThread mythread = new MyThread(null);
			MyThread.c++;
			list.add(mythread);
		}
		for (MyThread myThread : list) {
			try {
				myThread.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (true) {
			try {
				MyThread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(MyThread.c);
			if (MyThread.c == 0)
				break;
		}
		System.out.println(MyThread.a);
		System.out.println(MyThread.b);
	}
}
