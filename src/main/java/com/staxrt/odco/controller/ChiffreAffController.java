package com.staxrt.odco.controller;



import com.staxrt.odco.exception.ResourceNotFoundException;
import com.staxrt.odco.model.Chiffreaffaire;
import com.staxrt.odco.repository.ChiffreAffRepo;

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
public class ChiffreAffController {

  @Autowired
  private ChiffreAffRepo repo;

  @GetMapping("/chiffreaffs")
  public List<Chiffreaffaire> getAllchiffreaffs() {
      List<Chiffreaffaire> ca = repo.findAll();
	  return ca;
  }
  
  @GetMapping("/chiffreaffs/total")
  public List<Chiffreaffaire> getTotalchiffreaffs() {
      List<Chiffreaffaire> ca = repo.findChTotal();
	  return ca;
  }

  
  @GetMapping("/chiffreaffs/{id}")
  public ResponseEntity<Chiffreaffaire> getchiffreaffById(@PathVariable(value = "id") Integer id)
      throws ResourceNotFoundException {
    Chiffreaffaire ca =
        repo
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("chiffreaff not found on :: " + id));
    return ResponseEntity.ok().body(ca);
  }
  
  @GetMapping("/chiffreaffs/evolution")
  public List<Chiffreaffaire> getchiffreaffById(){
  List<Chiffreaffaire> ca = repo.findTotalYear();
  return ca;
  }

 
  @PostMapping("/chiffreaffs")
  public Chiffreaffaire createChiffreaff(@Valid @RequestBody Chiffreaffaire ca) {
    return repo.save(ca);
  }

  
  
 
   @DeleteMapping("/chiffreaff/{id}")
   public Map<String, Boolean> deleteCa(@PathVariable(value = "id") Integer id) throws Exception {
     Chiffreaffaire ca =
         repo
             .findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("chiffreaff not found on :: " + id));

     repo.delete(ca);
     Map<String, Boolean> response = new HashMap<>();
     response.put("deleted", Boolean.TRUE);
     return response;
   }
 

}
