package com.javaex.ex01;

public class Person {
	
	private String name;
	private String hp;
	private String phone;
	
	public Person() {}
	
	public Person(String name, String hp, String phone) {
		this.name = name;
		this.hp = hp;
		this.phone = phone;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void showInfo() {
		System.out.println(name + " " + hp + " " + phone);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", hp=" + hp + ", phone=" + phone + "]";
	}
	
	

}
