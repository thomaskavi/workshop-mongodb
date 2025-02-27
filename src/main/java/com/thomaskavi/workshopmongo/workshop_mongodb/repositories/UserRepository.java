package com.thomaskavi.workshopmongo.workshop_mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thomaskavi.workshopmongo.workshop_mongodb.models.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
