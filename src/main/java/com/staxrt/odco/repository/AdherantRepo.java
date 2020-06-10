package com.staxrt.odco.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.staxrt.odco.model.Adherant;
@Repository
public interface AdherantRepo extends JpaRepository<Adherant, Integer> {

}


