package com.staxrt.odco.controller;



import com.staxrt.odco.exception.ResourceNotFoundException;
import com.staxrt.odco.model.Province;
import com.staxrt.odco.repository.ProvinceRepo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ProvinceController {

  @Autowired
  private ProvinceRepo repo;

  @GetMapping("/provinces")
  public List<Province> getAllprovinces() {
      List<Province> sc = repo.findAll();
	  return sc;
  }

  
  @GetMapping("/provinces/{id}")
  public ResponseEntity<Province> getprovinceById(@PathVariable(value = "id") Integer id)
      throws ResourceNotFoundException {
    Province pr =
        repo
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("province not found on :: " + id));
    return ResponseEntity.ok().body(pr);
  }

 
  @PostMapping("/provinces")
  public Province createprovince(@Valid @RequestBody Province pr) {
    return repo.save(pr);
  }

  
  
  
 
   @DeleteMapping("/province/{id}")
   public Map<String, Boolean> deletePr(@PathVariable(value = "id") Integer id) throws Exception {
     Province pr =
         repo
             .findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("province not found on :: " + id));

     repo.delete(pr);
     Map<String, Boolean> response = new HashMap<>();
     response.put("deleted", Boolean.TRUE);
     return response;
   }
 

}
