package com.cjq.test.designMode;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeacherSubject teacher=new TeacherSubject();
        StudentObserver zhangSan=new StudentObserver("张三", teacher);
        StudentObserver LiSi=new StudentObserver("李四", teacher);
        StudentObserver WangWu=new StudentObserver("王五", teacher);
        
        teacher.setHomework("第二页第六题");
        teacher.setHomework("第三页第七题");
        teacher.setHomework("第五页第八题");
        teacher.notifyObserver();
	}

}
