package com.cjq.test.designMode;
/**
 * 
 * @className: Factory 
 * @description:宝马工厂
 * @author: chai_jianqiang@founder.com 
 * @date: 2017年11月4日 下午12:48:14
 */
public class Factory {
   public static BMW getBMWType(int type) {
	   switch (type) {
	   case 310:
		   return new BMW310();
	   case 510:
		   return new BMW510();

	   default:
		break;
	
	}
		return null;
   }
   public static void main(String[] args) {
	   BMW bmw=Factory.getBMWType(310);
	   bmw.getBMW();
   }
}
/**
 * 
 * @className: BMW 
 * @description:宝马接口
 * @author: chai_jianqiang@founder.com 
 * @date: 2017年11月4日 下午12:46:04
 */
interface BMW {
	public void getBMW();
}
/**
 * 
 * @className: BMW310 
 * @description:BMW310宝马
 * @author: chai_jianqiang@founder.com 
 * @date: 2017年11月4日 下午12:47:30
 */
class BMW310 implements BMW{

	@Override
	public void getBMW() {
	System.out.println("BMW310");	
	}
	public void say() {
		System.out.println("hello");
	}
}
/**
 * 
 * @className: BMW510 
 * @description:BMW510宝马
 * @author: chai_jianqiang@founder.com 
 * @date: 2017年11月4日 下午12:47:55
 */
class BMW510 implements BMW{
	@Override
	public void getBMW() {
	System.out.println("BMW510");	
	}
}