package com.springboot.multipleDB.repo.db2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.multipleDB.model.db2.DB2Model;

public interface DB2Repo extends JpaRepository <DB2Model, Integer>{

}
