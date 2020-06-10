package com.staxrt.odco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.staxrt.odco.exception.ResourceNotFoundException;
import com.staxrt.odco.model.Adherant;
import com.staxrt.odco.repository.AdherantRepo;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class AdherantController {

  @Autowired
  private AdherantRepo repo;

  @GetMapping("/adherants")
  public List<Adherant> getAllAdherants() {
      List<Adherant> ad = repo.findAll();
	  return ad;
  }

  
  @GetMapping("/adherants/{id}")
  public ResponseEntity<Adherant> getAdherantById(@PathVariable(value = "id") Integer id)
      throws ResourceNotFoundException {
    Adherant ad =
        repo
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("adherant not found on :: " + id));
    return ResponseEntity.ok().body(ad);
  }

 
  @PostMapping("/adherants")
  public Adherant createUser(@Valid @RequestBody Adherant ad) {
    return repo.save(ad);
  }

  
  
  /*
  @PutMapping("/adherants/{id}")
  public ResponseEntity<Adherant> updateAd(
      @PathVariable(value = "id") Integer id, @Valid @RequestBody Adherant AdDetails)
      throws ResourceNotFoundException {

    Adherant ad =
        repo
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("adherant not found on :: " + id));

    ad.setNombre_ad(ad.getNombre_ad());;
    final Adherant updatedAd = repo.save(ad);
    return ResponseEntity.ok(updatedAd);
  }
*/
  
 
   @DeleteMapping("/adherant/{id}")
   public Map<String, Boolean> deleteAd(@PathVariable(value = "id") Integer id) throws Exception {
     Adherant ad =
         repo
             .findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("Adherant not found on :: " + id));

     repo.delete(ad);
     Map<String, Boolean> response = new HashMap<>();
     response.put("deleted", Boolean.TRUE);
     return response;
   }
 

}
