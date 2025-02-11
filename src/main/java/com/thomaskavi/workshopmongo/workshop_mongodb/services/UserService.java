package com.thomaskavi.workshopmongo.workshop_mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomaskavi.workshopmongo.workshop_mongodb.models.dto.UserDTO;
import com.thomaskavi.workshopmongo.workshop_mongodb.models.entities.User;
import com.thomaskavi.workshopmongo.workshop_mongodb.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<UserDTO> findAll() {
    List<User> list = repository.findAll();
    return list.stream().map(x -> new UserDTO(x)).toList();
  }
}
