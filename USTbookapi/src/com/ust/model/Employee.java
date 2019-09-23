package com.ust.model;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	private String username;
	private String password;
	
	
	
	public Employee() {
		super();
	}
	
	public Employee(int id, String name, int age, String username,
			String password, int roleid, String rolename) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.username = username;
		this.password = password;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	

}
