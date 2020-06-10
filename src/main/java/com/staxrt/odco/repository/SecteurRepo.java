package com.staxrt.odco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.staxrt.odco.model.Region;
import com.staxrt.odco.model.Secteur;

@Repository
public interface SecteurRepo extends JpaRepository<Secteur, Integer> {
	
	@Query(value =
	           "SELECT " +
	                   "v" +
	                   " FROM" +
	                   " Secteur v GROUP BY v.idSecteur" )
			  
	List<Secteur> findAllcp();


}