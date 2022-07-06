package com.RoadAccidentsData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RoadAccidentsData.dao.JpaUserDetailsService;
import com.RoadAccidentsData.dao.accidentDao;
import com.RoadAccidentsData.entity.accidents;
import com.RoadAccidentsData.entity.user;
import com.RoadAccidentsData.entity.vehicles;
import com.RoadAccidentsData.entity.victims;

@RestController
@RequestMapping("/api")
public class accidentsRestController {

	@Autowired
	private accidentDao accidentDao;
	
	@Autowired
	private PasswordEncoder PasswordEncoder;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	//expose all accidents
	//get all accidents
	@GetMapping("/accidents")
	public List<accidents> findALL()
	{
		List<accidents> accidents= accidentDao.findALL();
		
		return accidents;
		
	}
	//get accident by id
	@GetMapping("/accidents/{accidentid}")
	public accidents getAccident(@PathVariable("accidentid") int id)
	{
		accidents accident= accidentDao.getAccident(id);
		
		return accident;
		
	}
	//get victims by id
	@GetMapping("/accidents/victims/{accidentid}")
	public List<victims> getVictims(@PathVariable("accidentid") int id)
	{
		List<victims> victims= accidentDao.findVictims(id);
		//System.out.println(victims);
		return victims;
	}
	//get vehicles by id
	@GetMapping("/accidents/vehicles/{accidentid}")
	public List<vehicles> getVehicles(@PathVariable("accidentid") int id)
	{
		List<vehicles> thevehicles= accidentDao.findVehicles(id);
		//System.out.println(victims);
		return thevehicles;
	}
	
	//update victims by id
	@PutMapping("/accidents/victims/{accidentid}")
	public accidents updateVictims(@PathVariable("accidentid") int id,@RequestBody List<victims> victim)
	{
		accidentDao.updateVictims(id,victim);
		
		return accidentDao.getAccident(id);
	}
	//update vehicles by id
	@PutMapping("/accidents/vehicles/{accidentid}")
	public accidents updateVehicles(@PathVariable("accidentid") int id,@RequestBody List<vehicles> vehicle)
	{
		for(vehicles v: vehicle)
		{
			//System.out.println(v.getCompany());
		}
		accidentDao.updateVehicles(id,vehicle);
		
		return accidentDao.getAccident(id);
	}
		
	//add accident 
	@PostMapping("/accidents")
	public accidents saveAccident(@RequestBody accidents theAccident)
	{
		 theAccident.setId(0);
		 accidentDao.save(theAccident);
		 
		 return theAccident;
		
	}
	//update accident
	@PutMapping("/accidents")
	public accidents updateAccident(@RequestBody accidents theAccident)
	{
		 
		 accidentDao.save(theAccident);
		 
		 return theAccident;
	
	}
	//delete accident
	@PostMapping("/accidents/{accidentid}")
	public String deleteAccident(@PathVariable("accidentid") int id)
	{
		 
		 accidentDao.delete(id);
	     return " accident deleted with SR no: " + id;
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody user user)
	{
		 
		 user.setPassword(PasswordEncoder.encode(user.getPassword()));
		 
		 userDetailsService.addUser(user);
		 
		 return "success";
		 
	}
		 


}
