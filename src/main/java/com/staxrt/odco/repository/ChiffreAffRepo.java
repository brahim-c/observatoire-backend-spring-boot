package com.staxrt.odco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.staxrt.odco.model.Chiffreaffaire;
import com.staxrt.odco.model.Cooperative;

@Repository
public interface ChiffreAffRepo extends JpaRepository<Chiffreaffaire, Integer> {
	
	@Query(value =
	           "SELECT SUM(c.valeur) FROM Chiffreaffaire c " )
			  
	List<Chiffreaffaire> findChTotal();
	
	
	@Query(value =
	           "SELECT YEAR(c.date),SUM(c.valeur) FROM Chiffreaffaire c GROUP BY YEAR(c.date)" )
			  
	List<Chiffreaffaire> findTotalYear();
	
	
	
	
}