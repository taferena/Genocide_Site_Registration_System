package com.tigray.genocide;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface GenocideRepository extends MongoRepository<GenocideIncidence, String> {

}