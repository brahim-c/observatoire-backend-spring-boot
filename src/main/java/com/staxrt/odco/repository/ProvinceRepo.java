package com.staxrt.odco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.staxrt.odco.model.Province;

@Repository
public interface ProvinceRepo extends JpaRepository<Province, Integer> {

}