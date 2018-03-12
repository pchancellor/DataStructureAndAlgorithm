package com.link2map.entity;

public class Person {

	private String name ;
	private int age ;
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[" + name + "]: " + age;
	}
	
	private String composeInfo() throws Exception {
		if (name == null || age < 0) {
			throw new Exception("Invalid personal info");
		}
		return "[" + name + "  " + age + "]";
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person(int age) {
		this.age = age;
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
}
