package com.thomaskavi.workshopmongo.workshop_mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomaskavi.workshopmongo.workshop_mongodb.models.dto.PostDTO;
import com.thomaskavi.workshopmongo.workshop_mongodb.models.entities.Post;
import com.thomaskavi.workshopmongo.workshop_mongodb.repositories.PostRepository;
import com.thomaskavi.workshopmongo.workshop_mongodb.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {

  @Autowired
  private PostRepository repository;

  public PostDTO findById(String id) {
    Post entity = getEntityById(id);
    return new PostDTO(entity);
  }

  private Post getEntityById(String id) {
    Optional<Post> result = repository.findById(id);
    return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
  }

  public List<PostDTO> findByTitle(String text) {
    List<Post> list = repository.findByTitleContainingIgnoreCase(text);
    return list.stream().map(x -> new PostDTO(x)).toList();
  }
}
