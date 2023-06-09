package com.springboot.multipleDB.service.db1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.multipleDB.model.db1.DB1Model;
import com.springboot.multipleDB.repo.db1.DB1Repo;

import jakarta.annotation.PostConstruct;

@Service
public class DB1Service {
	
	@Autowired
	private DB1Repo db1Repo;
	
	public void saveAll() {
		
		db1Repo.saveAll(Stream.of(new DB1Model(111, "Ansh"), new DB1Model(222, "Harsha")).collect(Collectors.toList()));
	}
	
	public List<DB1Model> getAll() {
		
		return db1Repo.findAll();
	}
	

}
