package com.cjq.test.designMode;
/**
 * 
 * @className: Singleton 
 * @description:安全的单例模式（懒汉式）单例在第一调用的时候创建单例
 * @author: chai_jianqiang@founder.com 
 * @date: 2017年11月4日 下午12:17:46
 */
public class Singleton {
	private static Singleton  instance=null;
	private Singleton() {};
	public synchronized static Singleton getInstance() {
		if(instance==null) {
			instance=new Singleton();
		}
		return instance;
	}
	public void say() {
		System.out.println("懒汉式(单例)");
	}

	public static void main(String[] args) {
		Singleton.getInstance().say();
		Singleton1.getInstance().say();
	}
}
/**
 * 
 * @className: Singleton1 
 * @description:饿汉式单例（单例初始化的时候就创建实例）
 * @author: chai_jianqiang@founder.com 
 * @date: 2017年11月4日 下午12:22:35
 */
class Singleton1{
	private static Singleton1  instance=new Singleton1();
	private Singleton1() {};
	public  static Singleton1 getInstance() {
		return instance;
	}
	public void say() {
		System.out.println("饿汉式(单例)");
	}
}
