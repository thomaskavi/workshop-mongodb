package com.thomaskavi.workshopmongo.workshop_mongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thomaskavi.workshopmongo.workshop_mongodb.models.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  List<Post> findByTitleContainingIgnoreCase(String text);
}
