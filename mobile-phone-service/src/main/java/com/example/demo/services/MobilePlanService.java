package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.MobilePlan;
import com.example.demo.rep0.PlanRepository;


@Service
public class MobilePlanService {
	@Autowired
	private PlanRepository repo;

	
	
	public MobilePlanService(PlanRepository repo) {
		super();
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}
	
	public List<MobilePlan> findAll(){
		return this.repo.findAll();
	}
	
	public MobilePlan add(MobilePlan entity) {
		return this.repo.save(entity);
	}
	
	public MobilePlan findById(int id) {
        String message=new StringBuilder("Element With Given id").append(id).append("Not Found").toString();
        return this.repo.findById(id).orElseThrow(()->new RuntimeException(message));
    }

	public MobilePlan update(MobilePlan entity) {
		// TODO Auto-generated method stub
		return this.repo.save(entity);
	}

	public MobilePlan remove(int id) {
        // TODO Auto-generated method stub
        MobilePlan element=this.findById(id);
        this.repo.deleteById(id);
        return element;
    }
	
	public List<MobilePlan> findByPlanName(String planName) {
        String message1=new StringBuilder("Element With Given plan").append(planName).append("Not Found").toString();
        return this.repo.findByPlanName(planName);
    }

	public List<MobilePlan> getCostGrtThan(double srchAmount){
        return this.repo.getCostGrtThan(srchAmount);
    }
	
}
