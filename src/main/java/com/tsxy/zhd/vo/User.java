package com.tsxy.zhd.vo;

public class User {
	private int id;
	private String username;
	private String password;
	private int age;
	private String phono;
	
	
	public User() {
		super();
	}
	public User(int id, String username, String password, int age, String phono) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.phono = phono;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhono() {
		return phono;
	}
	public void setPhono(String phono) {
		this.phono = phono;
	}
	
}
