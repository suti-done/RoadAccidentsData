package com.RoadAccidentsData.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="vehicles")
public class vehicles {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="number")
	private String number;

	@Column(name="model")
	private String model;
	
	@Column(name="company")
	private String company;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="accidents_id")
	private accidents accident;

	//@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="owner_id")
	private owner owner;
	
	public vehicles()
	{
		
	}
	public vehicles(String number, String model, String company, owner owner) {
		super();
		this.number = number;
		this.model = model;
		this.company = company;
		this.owner = owner;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public accidents getAccident() {
		return accident;
	}

	public void setAccident(accidents accidents) {
		this.accident = accidents;
	}

	public owner getOwner() {
		return owner;
	}

	public void setOwner(owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "vehicles [id=" + id + ", number=" + number + ", model=" + model + ", company=" + company ;
	}

	
}
