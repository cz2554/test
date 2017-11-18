package com.cjq.test.designMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @className: Proxy 
 * @description:为其他对象提供一种代理以控制对这个对象的访问。
 * 通过反射机制，利用JDK提供的Proxy类，在程序运行的时候在内存中根据目标对象来创建代理对象，避免了类爆炸的出现。代理方法只写一此，使代码得到了复用。
 * @author: chai_jianqiang@founder.com 
 * @date: 2017年11月6日 上午10:06:56
 */
public class ProxyTest {
	public static void main(String[] args) {
		Reallogin reallogin=new Reallogin();
		ILogin proxylogin=new ProxyLogin(reallogin); 
		proxylogin.login();

          
        //创建代理对象：通过JDK内置的动态代理类java.lang.reflect.Proxy完成代理对象的动态创建  
        //参数：  
                                      ClassLoader loader;  
          //  这里的类装载器主要是用来装载在内存中生成的那个临时的字节码，  
          //  代理类的类装载器需要和目标类的类装载器一致。  
    
        Class[] interfaces;  
          //  代理类和目标类必须实现“同一些”接口。（一个类可以同时实现多个接口）  
    
        InvocationHandler handler;  
           // 当代理对象调用代理方法的时候，“注册”在调用处理器中的invoke方法会自动调用。
       
        ILogin proxy = (ILogin)Proxy.newProxyInstance(ILogin.class.getClassLoader(),new Class[]{ILogin.class},new TimerInvocationHandler(reallogin));   
          
        //通过执行代理对象的代理方法去执行目标对象的目标方法  
        proxy.login();  
        proxy.logout();  
     
	}

	

}
/** 
 * 公共接口，目标对象和代理都来实现 
 */  
 interface ILogin{  
        //登录  
    void login();  
    //登出  
    void logout();  
}  
 /** 
  * 目标对象，实现公共接口，达到登录登出的功能 
  */  
 class Reallogin implements ILogin{  
       
     public void login(){  
         try {  
             Thread.sleep(3200);  
         } catch (InterruptedException e) {  
             e.printStackTrace();  
         }  
         System.out.println("登录系统.....");  
     }  
       
     public void logout(){  
         try {  
             Thread.sleep(2200);  
         } catch (InterruptedException e) {  
             e.printStackTrace();  
         }  
         System.out.println("退出系统....");  
     }  
 }  
 
/**
 * 
 * @className: ProxyLogin 
 * @description:代理对象，代理目标对象Reallogin  
 * @author: chai_jianqiang@founder.com 
 * @date: 2017年11月6日 上午10:08:32
 */
class ProxyLogin implements ILogin{  
  
         //此类中包含了目标对象  
    private Reallogin target;  
      
    //构造方法  
    public ProxyLogin (Reallogin target){  
        this.target = target;  
    }  
      
    @Override  
    public void login() {  
             //开始时间  
        long begin = System.currentTimeMillis();  
        target.login();  
        //结束时间  
        long end = System.currentTimeMillis();  
        System.out.println("耗费时长"+(end-begin)+"毫秒");  
    }  
  
    @Override  
    public void logout() {  
        long begin = System.currentTimeMillis();  
        target.logout();  
        long end = System.currentTimeMillis();  
        System.out.println("耗费时长"+(end-begin)+"毫秒");  
    }  
  
} 

/** 
 * 此类需要实现InvocationHandler接口 
 * 调用处理器，当代理对象调用代理方法的时候，注册在调用处理器中的invoke方法会自动调用。 
 */  
class TimerInvocationHandler implements InvocationHandler {  
      
    //目标对象，通过反射机制获得  
    private Object target;  
    //构造方法  
    public TimerInvocationHandler(Object target){  
        this.target = target;  
    }  
      
    /** 
     *  参数： 
     *          Object proxy：代理对象的引用，proxy变量中保存代理对象的内存地址（这个参数很少用） 
     *          Method method：目标对象的目标方法。 
     *          Object[] args：目标对象的目标方法执行的时候所需要实参。 
     */  
    @Override  
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {  
        //开始时间  
        long begin = System.currentTimeMillis();  
  
        //执行目标对象中的方法  
        Object retValue = method.invoke(target, args);  
        //结束时间  
        long end = System.currentTimeMillis();  
        //计算时间  
        System.out.println("耗费时长"+(end-begin)+"毫秒");  
        return retValue;  
    }  
  
}  

