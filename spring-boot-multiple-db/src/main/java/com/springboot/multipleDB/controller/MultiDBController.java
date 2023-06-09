package com.springboot.multipleDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.multipleDB.model.db1.DB1Model;
import com.springboot.multipleDB.model.db2.DB2Model;
import com.springboot.multipleDB.service.db1.DB1Service;
import com.springboot.multipleDB.service.db2.DB2Service;

import jakarta.annotation.PostConstruct;

@RestController
public class MultiDBController {

	@Autowired
	private DB1Service db1Service;
	
	@Autowired
	private DB2Service db2Service;
	
	
	@PostConstruct
	public void saveAll() {
		
		db1Service.saveAll();
		db2Service.saveAll();
	}
	
	@GetMapping("/get1")
	public List<DB1Model> getAllDb1() {
		
		return db1Service.getAll();
	}
	
	@GetMapping("/get2")
	public List<DB2Model> getAllDb2() {
		
		return db2Service.getAll();
	}
	
	
}
