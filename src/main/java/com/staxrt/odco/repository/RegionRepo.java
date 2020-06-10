package com.staxrt.odco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.staxrt.odco.model.Region;

@Repository
public interface RegionRepo extends JpaRepository<Region, Integer> {
	
	@Query(value =
	           "SELECT " +
	                   "v" +
	                   " FROM" +
	                   " Region v GROUP BY v.idRegion" )
			  
	List<Region> findAllcp();

}