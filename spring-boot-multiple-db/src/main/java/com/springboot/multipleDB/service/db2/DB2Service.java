package com.springboot.multipleDB.service.db2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.multipleDB.model.db2.DB2Model;
import com.springboot.multipleDB.repo.db2.DB2Repo;

@Service	
public class DB2Service {
		
		@Autowired
		private DB2Repo db2Repo;
		
		public void saveAll() {
			
			db2Repo.saveAll(Stream.of(new DB2Model(111, "Ansh"), new DB2Model(222, "Harsha")).collect(Collectors.toList()));
		}
		
		public List<DB2Model> getAll() {
			
			return db2Repo.findAll();
		}
		
}
