package com.staxrt.odco.controller;



import com.staxrt.odco.exception.ResourceNotFoundException;
import com.staxrt.odco.model.Secteur;
import com.staxrt.odco.repository.SecteurRepo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class SecteurController {

  @Autowired
  private SecteurRepo repo;

  @GetMapping("/secteurs")
  public List<Secteur> getAllsecteurs() {
      List<Secteur> sc = repo.findAll();
	  return sc;
  }
  
  @GetMapping("/cparsecteurs")
  public List<Secteur> getAllCparsecteurs() {
      List<Secteur> sc = repo.findAllcp();
	  return sc;
  }

  
  @GetMapping("/secteurs/{id}")
  public ResponseEntity<Secteur> getsecteurById(@PathVariable(value = "id") Integer id)
      throws ResourceNotFoundException {
    Secteur sc =
        repo
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("secteur not found on :: " + id));
    return ResponseEntity.ok().body(sc);
  }

 
  @PostMapping("/secteurs")
  public Secteur createsecteur(@Valid @RequestBody Secteur sc) {
    return repo.save(sc);
  }

  
  
 
  
 
   @DeleteMapping("/secteur/{id}")
   public Map<String, Boolean> deleteSc(@PathVariable(value = "id") Integer id) throws Exception {
     Secteur sc =
         repo
             .findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("secteur not found on :: " + id));

     repo.delete(sc);
     Map<String, Boolean> response = new HashMap<>();
     response.put("deleted", Boolean.TRUE);
     return response;
   }
 

}
