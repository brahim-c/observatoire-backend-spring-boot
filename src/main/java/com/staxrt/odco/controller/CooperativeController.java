package com.staxrt.odco.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.staxrt.odco.exception.ResourceNotFoundException;
import com.staxrt.odco.model.Cooperative;
import com.staxrt.odco.repository.CooperativeRepo;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
public class CooperativeController {
	
	@Autowired
	CooperativeRepo repo;
	
	
	@GetMapping("cooperatives")
	@ResponseBody
	public List<Cooperative> GetCooperatives()
	{
		
		List<Cooperative> cp = repo.findAll();
		return cp;
	}
	
	@GetMapping("cooperatives/cpsc/{id}")
	@ResponseBody
	public List<Cooperative> GetCooperativeEtSc(@PathVariable("id") int id)
	{
		
		List<Cooperative> cp = repo.findcpetsc(id);
		return cp;
	}
	
	@GetMapping("cooperatives/cpsc")
	@ResponseBody
	public List<Cooperative> GetAllCooperativeEtSc()
	{
		
		List<Cooperative> cp = repo.findAllcpetsc();
		return cp;
	}
	
	
	@GetMapping("cooperatives/cpm/{id}")
	@ResponseBody
	public List<Cooperative> GetCooperativeEtIm(@PathVariable("id") int id)
	{
		
		List<Cooperative> cp = repo.findcpetim(id);
		return cp;
	}
	
	@GetMapping("cooperatives/cpm")
	@ResponseBody
	public List<Cooperative> GetAllCooperativeEtIm()
	{
		
		List<Cooperative> cp = repo.findAllcpetim();
		return cp;
	}
	
	
	
	@GetMapping("cooperatives/chiaff/{id}")
	@ResponseBody
	public List<Cooperative> GetCooperativeEtch(@PathVariable("id") int id)
	{
		
		List<Cooperative> cp = repo.findcpetchaff(id);
		return cp;
		//return "show all cooperatives";
	}
	
	@GetMapping("cooperatives/adh/{id}")
	@ResponseBody
	public List<Cooperative> GetCooperativeEtadh(@PathVariable("id") int id)
	{
		
		List<Cooperative> cp = repo.findcpetadh(id);
		return cp;
	}
	

	@GetMapping("cooperatives/ct/{id}")
	@ResponseBody
	public List<Cooperative> GetCooperativeEtct(@PathVariable("id") int id)
	{
		
		List<Cooperative> cp = repo.findcpetct(id);
		return cp;
	}
	
	@GetMapping("cooperatives/adr/{id}")
	@ResponseBody
	public List<Cooperative> GetCooperativeEtad(@PathVariable("id") int id)
	{
		
		List<Cooperative> cp = repo.findcpetad(id);
		return cp;
	}
	
	@GetMapping("cooperatives/total")
	@ResponseBody
	public List<Cooperative> GetCooperativeEtad()
	{
		
		List<Cooperative> cp = repo.findTotal();
		return cp;
	}
	
	@GetMapping("cooperatives/{adresse}")
	@ResponseBody
	public List<Cooperative> GetCooperativesbyad(@PathVariable("adresse") String ad)
	{
		
		List<Cooperative> cp = repo.findcpbyad(ad);
		return cp;
	}
	
	@GetMapping("cooperatives/NbEvolution")
	@ResponseBody
	public List<Cooperative> GetCooperativesEv()
	{
		
		List<Cooperative> cp = repo.findTotalcpSc();
		return cp;
	}
	
	@PostMapping(path = "/cooperatives")
	public Cooperative AddCooperative(@Valid @RequestBody Cooperative cp)
	{
		
		repo.save(cp);
		return cp;
	}
	
	
	
	@DeleteMapping("/cooperatives/{id}")
	  public Map<String, Boolean> deleteCp(@PathVariable(value = "id") int id) throws Exception {
	    Cooperative cp =
	        repo
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Cooperative not found on :: " + id));

	    repo.delete(cp);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }
	
	
	
	

}
