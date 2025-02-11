package com.thomaskavi.workshopmongo.workshop_mongodb.models.embedded;

import com.thomaskavi.workshopmongo.workshop_mongodb.models.entities.User;

public class Author {

  private String id;
  private String name;

  public Author() {
  }

  public Author(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Author(User entity) {
    id = entity.getId();
    name = entity.getName();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
