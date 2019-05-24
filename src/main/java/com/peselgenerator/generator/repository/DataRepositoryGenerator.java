package com.peselgenerator.generator.repository;


import com.peselgenerator.generator.entity.UserDataGenerator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DataRepositoryGenerator extends CrudRepository<UserDataGenerator, Integer> {



}
