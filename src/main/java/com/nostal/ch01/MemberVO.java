package com.nostal.ch01;

import java.sql.Date;
import java.time.LocalDate;
import java.lang.String;

public class MemberVO {
	// uid, pwd, 이름, 생년월일, email, 성별, 취미, 가입일
	private String uid;
	private String pwd;
	private String uname;
	private Date birth;
	private String email;
	private String gender;
	private String hobby;
	private LocalDate joinDate;
	
	// 기본 생성자
	MemberVO () {
		System.out.println("MemberVO 생성자 호출");
	}

	// 가입일자 포함하지 않은 생성자
	public MemberVO(String uid, String pwd, String uname, Date birth, String email, String gender, String hobby) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
		this.hobby = hobby;
	}

	// 가입일자 포함한 생성자
	public MemberVO(String uid, String pwd, String uname, Date birth, String email, String gender, String hobby,
			LocalDate joinDate) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
		this.hobby = hobby;
		this.joinDate = joinDate;
	}

	// Getter, Setter
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	// toString
	public String toString() {
		return "MemberVO [uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", birth=" + birth + ", email=" + email
				+ ", gender=" + gender + ", hobby=" + hobby + ", joinDate=" + joinDate + "]";
	}

}