package com.staxrt.odco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.staxrt.odco.exception.ResourceNotFoundException;
import com.staxrt.odco.model.Region;
import com.staxrt.odco.repository.RegionRepo;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class RegionController {

  @Autowired
  private RegionRepo repo;

  @GetMapping("/regions")
  public List<Region> getAllRegions() {
      List<Region> rg = repo.findAll();
	  return rg;
  }
  @GetMapping("/cooparegions")
  public List<Region> getAllCPparRegions() {
      List<Region> rg = repo.findAllcp();
	  return rg;
  }

  
  @GetMapping("/regions/{id}")
  public ResponseEntity<Region> getRegionById(@PathVariable(value = "id") Integer id)
      throws ResourceNotFoundException {
    Region rg =
        repo
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("region not found on :: " + id));
    return ResponseEntity.ok().body(rg);
  }

 
  @PostMapping("/regions")
  public Region createRegion(@Valid @RequestBody Region rg) {
    return repo.save(rg);
  }

 
 
   @DeleteMapping("/region/{id}")
   public Map<String, Boolean> deleteRg(@PathVariable(value = "id") Integer id) throws Exception {
     Region Rg =
         repo
             .findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("Region not found on :: " + id));

     repo.delete(Rg);
     Map<String, Boolean> response = new HashMap<>();
     response.put("deleted", Boolean.TRUE);
     return response;
   }
 

}
