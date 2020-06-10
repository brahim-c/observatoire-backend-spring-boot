package com.staxrt.odco.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.staxrt.odco.model.Cooperative;
import com.staxrt.odco.model.Region;;
@Repository
public interface CooperativeRepo extends JpaRepository<Cooperative, Integer> {

	@Query(value =
	           "SELECT c.nomCoop,s.nomSec FROM Cooperative c, Secteur s WHERE c.idCoop = :idCoop and s.idSecteur = c.idSecteur" )
			  
	List<Cooperative> findcpetsc(Integer idCoop);
	
	
	@Query(value =
	           "SELECT c.nomCoop,s.nomSec FROM Cooperative c, Secteur s WHERE s.idSecteur = c.idSecteur" )
			  
	List<Cooperative> findAllcpetsc();
	
	
	@Query(value =
	           "SELECT c.nomCoop,c.description,c.image FROM Cooperative c WHERE c.idCoop = :idCoop" )
			  
	List<Cooperative> findcpetim(Integer idCoop);
	
	@Query(value =
	           "SELECT c.nomCoop,c.description,c.image FROM Cooperative c" )
			  
	List<Cooperative> findAllcpetim();
	
	
	
	@Query(value =
	           "SELECT c.chiffreaffaireCollection FROM Cooperative c WHERE c.idCoop = :idCoop" )
			  
	List<Cooperative> findcpetchaff(Integer idCoop);
	
	@Query(value =
	           "SELECT c.adherantCollection FROM Cooperative c WHERE c.idCoop = :idCoop" )
			  
	List<Cooperative> findcpetadh(Integer idCoop);
	
	
	@Query(value =
	           "SELECT (c.employeeFemmes*100)/(c.employeeFemmes+c.employeeHommes),(c.employeeHommes*100)/(c.employeeFemmes+c.employeeHommes) FROM Cooperative c WHERE c.idCoop = :idCoop" )
			  
	List<Cooperative> findcpetct(Integer idCoop);
	
	
	@Query(value =
	           "SELECT c.adresse FROM Cooperative c WHERE c.idCoop = :idCoop" )
			  
	List<Cooperative> findcpetad(Integer idCoop);
	
	
	@Query(value =
	           "SELECT COUNT(*) FROM Cooperative c" )
			  
	List<Cooperative> findTotal();
	
	@Query(value =
	           "SELECT c.nomCoop FROM Cooperative c WHERE c.adresse = :adresse" )
			  
	List<Cooperative> findcpbyad(String adresse);
	
	

	@Query(value =
	           "SELECT YEAR(c.dateCreation),v.nomSec,COUNT(c.idCoop) FROM Cooperative c, Secteur v WHERE c.idSecteur = v.idSecteur GROUP BY YEAR(c.dateCreation)" )
			  
	List<Cooperative> findTotalcpSc();
	
	

}

