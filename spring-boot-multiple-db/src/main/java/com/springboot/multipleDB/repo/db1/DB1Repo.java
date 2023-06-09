package com.springboot.multipleDB.repo.db1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.multipleDB.model.db1.DB1Model;

public interface DB1Repo extends JpaRepository<DB1Model, Integer>{

}
