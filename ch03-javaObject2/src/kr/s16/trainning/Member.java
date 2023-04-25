package kr.s16.trainning;

import java.io.Serializable;

public class Member implements Serializable{
	//private static final long serialVersionUID = 1L;
	/*
	 * [실습]
	 * 멤버 변수: 이름(name) 나이(age) 직업(job) 주소(address) 휴대폰(phone) 취미(hobby)
	 * 생성자 : 인자가 없는 생성자, 인자가 있는 생성자
	 * 멤버 메소드 : get/set 메소드
	 */
	private String name, job, address, phone, hobby;
	private int age;
	
	public Member() {	}
	public Member(String name, int age, String job, String address, String phone, String hobby) {
		this.name = name; this.age = age; this.job = job; this.address = address; this.phone = phone; this.hobby = hobby;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {//★String.format
		return String.format("%s\t%d\t%s\t%s\t%s\t%s\n", name, age, job, address, phone, hobby);
	}
	
}