package com.tsxy.zhd.vo;

//用户信息
public class User {
	private Integer id;//主键
	private String username;//用户名
	private String password;//密码
	private String  sex;//性别
	private String  phoneNumber;//手机号
	private String  birthday;//生日
	private String  idNumber;//证件号码
	private String  career;//职业
	private String  inTime;//入会时间
	private String  address;//详细地址
	private String  remarks;//备注
	private String  tag;//角色标志      
	public User() {
		super();
	}
	
	public User(Integer id, String username, String password, String sex, String phoneNumber, String birthday,
			String idNumber, String career, String inTime, String address, String remarks, String tag) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.idNumber = idNumber;
		this.career = career;
		this.inTime = inTime;
		this.address = address;
		this.remarks = remarks;
		this.tag = tag;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
