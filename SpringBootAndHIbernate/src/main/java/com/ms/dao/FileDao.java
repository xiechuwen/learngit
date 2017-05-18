package com.ms.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ms.pojo.File;

@Repository
@Qualifier(value = "fileDao")
public interface FileDao extends CrudRepository<File, Integer>{

}
