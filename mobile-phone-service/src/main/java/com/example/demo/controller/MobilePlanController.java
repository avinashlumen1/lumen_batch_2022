package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.MobilePlan;
import com.example.demo.services.MobilePlanService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/mobileplans")
@AllArgsConstructor
public class MobilePlanController {

	@Autowired
	private MobilePlanService service;
	
	@GetMapping
	public List<MobilePlan> getAll(){
		return this.service.findAll();
	}
	
	@GetMapping("/srch/{id}")
    public MobilePlan findById(@PathVariable("id") int id) {
        return this.service.findById(id);
    }
	
	@PostMapping
    public ResponseEntity<MobilePlan> add(@RequestBody MobilePlan entity){
        MobilePlan addedObj=this.service.add(entity);
        
        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
                buildAndExpand(entity.getPlantId()).toUri();
        return ResponseEntity.created(location).body(addedObj);
    }
	
	@PutMapping
    public ResponseEntity<MobilePlan> update(@RequestBody MobilePlan entity){
        MobilePlan addedObj=this.service.update(entity);
        return ResponseEntity.ok().body(addedObj);
    }
	
	@DeleteMapping(path="{id}")
    public ResponseEntity<String> remove(@PathVariable("id")int id){
        MobilePlan deletedElement = this.service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted one Record");
    }
	
	@GetMapping("/srch/plan/{planName}")
    public List<MobilePlan> findByPlanName(@PathVariable("planName") String planName) {
        return this.service.findByPlanName(planName);
    }
	
	
	@GetMapping("/srch/amount/{srchAmount}")
    public List<MobilePlan> getCostGrtThan(@PathVariable("srchAmount") double srchAmount){
        return this.service.getCostGrtThan(srchAmount);
    }
}
