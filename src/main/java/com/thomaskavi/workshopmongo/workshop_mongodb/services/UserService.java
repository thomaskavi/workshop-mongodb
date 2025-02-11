package com.thomaskavi.workshopmongo.workshop_mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomaskavi.workshopmongo.workshop_mongodb.models.dto.UserDTO;
import com.thomaskavi.workshopmongo.workshop_mongodb.models.entities.User;
import com.thomaskavi.workshopmongo.workshop_mongodb.repositories.UserRepository;
import com.thomaskavi.workshopmongo.workshop_mongodb.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<UserDTO> findAll() {
    List<User> list = repository.findAll();
    return list.stream().map(x -> new UserDTO(x)).toList();
  }

  public UserDTO findById(String id) {
    User entity = getEntityById(id);
    return new UserDTO(entity);
  }

  private User getEntityById(String id) {
    Optional<User> result = repository.findById(id);
    return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
  }

  public UserDTO insert(UserDTO dto) {
    User entity = new User();
    copyDtoToEntity(dto, entity);
    entity = repository.insert(entity);
    return new UserDTO(entity);
  }

  public UserDTO update(String id, UserDTO dto) {
    User entity = getEntityById(id);
    copyDtoToEntity(dto, entity);
    entity = repository.save(entity);
    return new UserDTO(entity);
  }

  private void copyDtoToEntity(UserDTO dto, User entity) {
    entity.setName(dto.getName());
    entity.setEmail(dto.getEmail());
  }
}
