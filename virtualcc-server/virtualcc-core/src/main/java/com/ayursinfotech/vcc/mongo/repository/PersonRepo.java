package com.ayursinfotech.vcc.mongo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ayursinfotech.vcc.mongo.entity.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {

}