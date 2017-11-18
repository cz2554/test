package com.cjq.test.designMode;
/**
 * 
 * @className: Adapter 
 * @description:适配器模式举例
 * @author: chai_jianqiang@founder.com 
 * @date: 2017年11月4日 下午4:31:13
 */
public class Adapter implements Ps2  {

	private Usb usb;
	public Adapter(Usb usb) {
		this.usb=usb;
	}
	@Override
	public void isPs2() {
		// TODO Auto-generated method stub
		usb.isUsb();
		
	}
	public static void main(String[] args) {
		Usb usb=new Usber();
		Adapter adapter=new Adapter(usb);
		adapter.isPs2();
	}

}

interface Usb{
	public void isUsb();
}
class Usber implements Usb{

	@Override
	public void isUsb() {
		System.out.println("usb接口实现");
		
	}
	
}
interface Ps2 {
   void isPs2();
   }
