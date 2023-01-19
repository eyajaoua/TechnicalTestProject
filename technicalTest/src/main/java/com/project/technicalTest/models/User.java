package com.project.technicalTest.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "userName", nullable = false, unique = true)
	private String userName;

	@Column(name = "birthdate", nullable = false)
	private Date birthdate;

	@Column(name = "residence", nullable = false)
	private String residence;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "gender")
	private String gender;

	public User() {

	}

	public User(String userName, Date birthdate, String residence) {
		this.userName = userName;
		this.birthdate = birthdate;
		this.residence = residence;
	}

	public User(String userName, Date birthdate, String residence, String phoneNumber, String gender) {
		this(userName, birthdate, residence);
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
