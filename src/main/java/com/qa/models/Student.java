package com.qa.models;

public class Student {
	
	private String name;
	private String address;
	private int age;
	private int phoneNo;
	
	
	public Student() {}
	
	public Student(String name, String address, int age, int phoneNo) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.phoneNo = phoneNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
}
