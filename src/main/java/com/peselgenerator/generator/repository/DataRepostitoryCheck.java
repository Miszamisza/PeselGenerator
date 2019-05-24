package com.peselgenerator.generator.repository;

import com.peselgenerator.generator.entity.UserDataCheck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepostitoryCheck extends CrudRepository<UserDataCheck, Integer> {

}
