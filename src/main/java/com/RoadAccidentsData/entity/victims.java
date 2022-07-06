package com.RoadAccidentsData.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="victims")
public class victims {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
    
	@Column(name="address")
	private String address;
	
	@Column(name="contact_number")
	private String contact_number;
	
	@Column(name="age")
	private int age;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="accident_id")
	@JsonIgnore
	private accidents accidents;
	
	public victims()
	{
		
	}

	public victims(String name, String address, String contact_number, int age) {
	
		this.name = name;
		this.address = address;
		this.contact_number = contact_number;
		this.age = age;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public accidents getAccidents() {
		return accidents;
	}

	public void setAccidents(accidents accidents) {
		this.accidents = accidents;
	}

	@Override
	public String toString() {
		return "victims [id=" + id + ", name=" + name + ", address=" + address + ", contact_number=" + contact_number
				+ ", age=" + age + "]";
	}
    
	
}
