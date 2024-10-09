package org.gq.learngraphql.model;

import java.time.LocalDateTime;

public class Post {

  static Integer counter = 0;
  Integer id;
  String title;
  String description;
  LocalDateTime createdAt;

  public Post(String title, String description) { 
    counter++;
    this.id = counter;
    this.title = title;
    this.description = description;
    this.createdAt = LocalDateTime.now();
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
