package com.RoadAccidentsData.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity(name="users")
public class user {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String username;
 private String password;
 private int enabled=1;


@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
 private List<Authority> authorities;
	
 
 public List<Authority> getAuthorities() {
	return authorities;
}

public void setAuthorities(List<Authority> authorities) {
	this.authorities = authorities;
}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	} 

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", authorities=" + authorities + "]";
	}
	

	
	



}
