package com.cjq.test.invoke;

public class Employee {
 private String id;
 private String name;
 private String no;
 private Employee() {};
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getNo() {
	return no;
}
public void setNo(String no) {
	this.no = no;
}
public void system(String str1,String str2) {
	System.out.println(str1+" "+str2);
}
}
