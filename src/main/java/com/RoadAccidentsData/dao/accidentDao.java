package com.RoadAccidentsData.dao;

import java.util.List;

import com.RoadAccidentsData.entity.accidents;
import com.RoadAccidentsData.entity.vehicles;
import com.RoadAccidentsData.entity.victims;

public interface accidentDao {
	
	public List<accidents> findALL();

	void save(accidents accident);

	void delete(int id);

	accidents getAccident(int id);

	List<victims> findVictims(int id);

	public List<vehicles> findVehicles(int id);

	public void updateVictims(int id, List<victims>victim);

	public void updateVehicles(int id, List<vehicles> vehicles);

}
