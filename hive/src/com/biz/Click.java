package com.biz;

//Click 이름의 함수를 생성 -> biz,dao(interface)생성

public class Click {
 private String id;
 private String item;
 private String price;
 private String gender;
 private String age;
public Click() {
	super();
}
public Click(String id, String item, String price, String gender, String age) {
	super();
	this.id = id;
	this.item = item;
	this.price = price;
	this.gender = gender;
	this.age = age;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
@Override
public String toString() {
	return "Click [id=" + id + ", item=" + item + ", price=" + price + ", gender=" + gender + ", age=" + age + "]";
}
 
 
}
