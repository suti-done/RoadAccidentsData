package com.RoadAccidentsData.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.RoadAccidentsData.entity.accidents;
import com.RoadAccidentsData.entity.vehicles;
import com.RoadAccidentsData.entity.victims;


@Repository
public class accidentsHibernateDaoImp implements accidentDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<accidents> findALL() {
		
	   Session currentSession = entityManager.unwrap(Session.class);
	   Query<accidents> query= currentSession.createQuery("from accidents",accidents.class);
	   List<accidents> accidents=query.getResultList();
	   
	   return accidents;
	}
	@Override
	@Transactional
	public List<victims> findVictims(int id) {
		
		accidents theAccident=getAccident(id);
	   
	   return theAccident.getVictims();
	}
	@Override
	public List<vehicles> findVehicles(int id)
	{
		
	    accidents theAccident=getAccident(id);
	    
	    return theAccident.getVehicles();
	}
    
	@Override
	@Transactional
	public void save(accidents accident) {
		
	   Session currentSession = entityManager.unwrap(Session.class);
	   //get existing accident
	   accidents theAccident=getAccident(accident.getId());
	   //preserve the reporter
	   accident.setReporter(theAccident.getReporter());
	   
	   currentSession.saveOrUpdate(accident);
	   
	  
	}
	
	@Override
	@Transactional
	public accidents getAccident(int id) {
		
	   Session currentSession = entityManager.unwrap(Session.class);
	   
	   accidents theAccident=currentSession.get(accidents.class,id);
	   
	   System.out.println(theAccident);
	   return theAccident;
	   
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		
	   Session currentSession = entityManager.unwrap(Session.class);
	   Query query= currentSession.createQuery("delete from accidents where id=:n");
	   query.setParameter("n", id);
	   query.executeUpdate();
	   
	}
	@Override
	public void updateVictims(int id, List<victims> victim) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		accidents theAccident=getAccident(id);
		for(victims v: victim)
		{
			v.setAccidents(theAccident);
			currentSession.saveOrUpdate(v);
		}
		
		
	}
	@Override
	public void updateVehicles(int id, List<vehicles> vehicles) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		accidents theAccident=getAccident(id);
		for(vehicles v: vehicles)
		{
			v.setAccident(theAccident);
			currentSession.saveOrUpdate(v);
		}
		
		 
		
	}
    
}
