package com.cjq.test.aop.Tread;


import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;  
/**  
 *  
 * @Description: 实现了等待锁的时候，5秒没有获取到锁，中断等待，线程继续做其它事情。  
 * 参考：http://hi.baidu.com/cyberniuniu/item/7fdba2fbe9373b733d198b34  
 * @author thrillerzw  
 * @version 1.0  
 * @create time 2014-4-25 下午1:38:17  
 * 输出：  
 * 开始往这个buff写入数据…  
 不等了，尝试中断  
 我不读了  
 读结束  
 */  
public class ReentrantLockTest {  
    public static void main(String[] args) throws InterruptedException {  
        BufferInterruptibly buff = new BufferInterruptibly();  
       
        final Writer writer = new Writer(buff);  
        final Reader reader = new Reader(buff);  
        final SingletonClass  instant=new SingletonClass();
       /*
        writer.start();  
        Thread.sleep(1000);  
        reader.start();  */
       final Map<String,String> hashtable=new Hashtable<String,String>();
       for (int i=1;i<100;i++) {
    	   hashtable.put("0", i+"");
    	   new Thread(new Runnable() {  
    	       
               @Override  
               public void run() {  
                   
                       
          
            	   instant.runaaa(hashtable);
          
               }  
           }).start(); 
       }
       /* new Thread(new Runnable() {  
       
            @Override  
            public void run() {  
                long start = System.currentTimeMillis();  
                for (;;) {  
                    if (System.currentTimeMillis()  
                            - start > 10000) {  
                        System.out.println("不等了，尝试中断");  
                        reader.interrupt();  
                        break;  
                    }  
       
                }  
       
            }  
        }).start();  */
       
    }  
     
    public static class BufferInterruptibly {  
         
        private ReentrantLock lock = new ReentrantLock();  
           
        public void write() {  
        	 try {
				boolean b=lock.tryLock(4, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {  
                long startTime = System.currentTimeMillis();  
                System.out.println("开始往这个buff写入数据…");  
                for (;;)// 模拟要处理很长时间  
                {  
                    if (System.currentTimeMillis()  
                            - startTime > Integer.MAX_VALUE)  
                        break;  
                }  
                System.out.println("终于写完了");  
            } finally {  
                lock.unlock();  
            }  
        }  
        public void read() throws InterruptedException {  
            lock.lockInterruptibly();//注意这里，可以响应中断，抛出中断异常。  
            try {  
                System.out.println("从这个buff读数据");  
            } finally {  
                lock.unlock();  
            }  
        }  
    }  
     
    public static class Writer extends Thread {  
         
        private BufferInterruptibly buff;  
           
        public Writer(BufferInterruptibly buff) {  
            this.buff = buff;  
        }  
           
        @Override  
        public void run() {  
            buff.write();  
            System.out.println("写结束");  
        }  
           
    }  
    public static class Reader extends Thread {  
         
        private BufferInterruptibly buff;  
           
        public Reader(BufferInterruptibly buff) {  
            this.buff = buff;  
        }  
           
        @Override  
        public void run() {  
           
            try {  
                buff.read();//可以收到中断的异常，从而有效退出  
            } catch (InterruptedException e) {  
                System.out.println("我不读了");  
            }  
                 
            System.out.println("读结束，去做其它事情");  
           
        }  
           
    }  
}