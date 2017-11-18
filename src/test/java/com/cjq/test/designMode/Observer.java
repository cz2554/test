package com.cjq.test.designMode;

import java.util.ArrayList;
import java.util.List;

public interface Observer {
	//当主题状态改变时,会将一个String类型字符传入该方法的参数,每个观察者都需要实现该方法
    public void update(String info);
    
}
//主题接口
interface Subject {
   //添加观察者
   void addObserver(Observer obj);
   //移除观察者
   void deleteObserver(Observer obj);
   //当主题方法改变时,这个方法被调用,通知所有的观察者
   void notifyObserver();
}


class TeacherSubject implements Subject {
    //用来存放和记录观察者
    private List<Observer> observers=new ArrayList<Observer>();
    //记录状态的字符串
    private String info;
    
    @Override
    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void deleteObserver(Observer obj) {
        int i = observers.indexOf(obj);
        if(i>=0){
            observers.remove(obj);
        }
    }
//通知所有的观察者
    @Override
    public void notifyObserver() {
        for(int i=0;i<observers.size();i++){
            Observer o=(Observer)observers.get(i);
            o.update(info);
        }
    }
    //布置作业的方法,在方法最后,需要调用notifyObserver()方法,通知所有观察者更新状态
    public void setHomework(String info){
        this.info=info;
        System.out.println("今天的作业是"+info);
        this.notifyObserver();
    }

}


 class StudentObserver implements Observer {

    //保存一个Subject的引用,以后如果可以想取消订阅,有了这个引用会比较方便
    private TeacherSubject t;
    //学生的姓名,用来标识不同的学生对象
    private String name;
    //构造器用来注册观察者
    public StudentObserver(String name,TeacherSubject t) {
        this.name=name;
        this.t = t;
        //每新建一个学生对象,默认添加到观察者的行列
        t.addObserver(this);
    }


    @Override
    public void update(String info) {
        System.out.println(name+"得到作业:"+info);
        
    }

}
 
 