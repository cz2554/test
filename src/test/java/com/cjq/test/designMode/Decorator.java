package com.cjq.test.designMode;
/**
 * 
 * @className: Decorator 
 * @description:装饰者模式是在已有功能的基础之上，
 * 动态地添加更多 功能的一种方式，这些新加的代码装饰了原有类的 核心职责或主要行为。
 * 设计原则： 
	1. 多用组合，少用继承。 
	利用继承设计子类的行为，是在编译时静态决定的，而且所有的子类都会继承到相同的行为。然而，如果能够利用组合的做法扩展对象的行为，就可以在运行时动态地进行扩展。 
	2. 类应设计的对扩展开放，对修改关闭。 
 * @author: chai_jianqiang@founder.com 
 * @date: 2017年11月4日 下午4:37:31
 */
public class Decorator implements Component
{
	public Decorator(Component component)
	{
		this.component = component;
	}
	
	public void operation()
	{
		component.operation();
	}
	
	private Component component;
	
	public static void main(String[] args) {
		Component  component=new ConcreteComponent();
		Component decorator=new ConcreteDecorator(component);
		decorator.operation();
	}
}
class ConcreteDecorator extends Decorator
{
	public ConcreteDecorator(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}

	public void operation()
	{
		//addBehavior也可以在前面
		addBehavior();
		super.operation();
		
	
	}
	
	private void addBehavior()
	{
		System.out.println("加入了糖");
	}
}
 interface Component
{
	void operation();
}
class ConcreteComponent implements Component
 {
 	public void operation()
 	{
 		System.out.println("我是一杯咖啡");
 	}
 }
