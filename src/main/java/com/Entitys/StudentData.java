package com.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.*; 

@Entity
@Table(name="StudnetData")
public class StudentData {
	
	@Id
	private int id;
	
	private String name;
	private String age;
	private String location; 
	
	private Date addedDate; 
	

	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public StudentData(String name, String age, String location, Date addedDate ) {
		super();
		this.id = new Random().nextInt(1000);
		this.name = name;
		this.age = age;
		this.location = location;
	        
		this.addedDate = addedDate;
	}
	public StudentData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
