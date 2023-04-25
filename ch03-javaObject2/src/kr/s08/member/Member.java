package kr.s08.member;

public class Member {
	/*
	 * [실습]
	 * 멤버 변수 : 이름(name), 나이(age), 직업(job), 주소(address), 전화번호(phone)
	 * 멤버 메소드 : get/set 메소드 정의
	 * 
	 */
	private String name; private String job; private String address; private String phone;
	private int age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}