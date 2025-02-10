package com.thomaskavi.workshopmongo.workshop_mongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.thomaskavi.workshopmongo.workshop_mongodb.models.entities.User;
import com.thomaskavi.workshopmongo.workshop_mongodb.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestConfig {

  @Autowired
  private UserRepository userRepository;

  @PostConstruct
  public void init() {

    userRepository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Brown", "bob@gmail.com");

    userRepository.saveAll(Arrays.asList(maria, alex, bob));
  }
}
