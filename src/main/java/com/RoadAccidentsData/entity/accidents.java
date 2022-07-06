package com.RoadAccidentsData.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="accidents")
public class accidents {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="state")
	private String state;
	
	@Column(name="district")
	private String district;
	
	@Column(name="location")
	private String location;
	
	@Column(name="deaths")
	private int deaths;
	
	@Column(name="injured")
	private int injured;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="reporter_id")
	private reporter reporter;
	
	@OneToMany(mappedBy="accidents",cascade=CascadeType.ALL)
	//@JsonIgnore
	private List<victims> victims;
	
	//@JsonIgnore
	@OneToMany(mappedBy="accident",cascade=CascadeType.ALL)
	private List<vehicles> vehicles;
	
	public accidents()
	{
		
	}

	public accidents(String state, String district, String location, int deaths, int injured) {
		
		this.state = state;
		this.district = district;
		this.location = location;
		this.deaths = deaths;
		this.injured = injured;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getInjured() {
		return injured;
	}

	public void setInjured(int injured) {
		this.injured = injured;
	}
	
	

	public reporter getReporter() {
		return reporter;
	}

	public void setReporter(reporter reporter) {
		this.reporter = reporter;
	}

	public List<victims> getVictims() {
		return victims;
	}

	public void setVictims(List<victims> victims) {
		this.victims = victims;
	}

	public void add(victims thevictims)
	{
		if(victims==null)
		{
			victims=new ArrayList<>();
		}
		victims.add(thevictims);
		thevictims.setAccidents(this);
	}
	public List<vehicles> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<vehicles> vehicles) {
		this.vehicles = vehicles;
	}
    
	public void add(vehicles thevehicles)
	{
		if(vehicles==null)
		{
			vehicles=new ArrayList<>();
		}
		vehicles.add(thevehicles);
		thevehicles.setAccident(this);
	} 
	
	@Override
	public String toString() {
		return "accidents [id=" + id + ", state=" + state + ", district=" + district + ", location=" + location
				+ ", deaths=" + deaths + ", injured=" + injured + "]";
	}
	

}
