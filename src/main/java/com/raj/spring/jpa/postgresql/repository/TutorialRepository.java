package com.raj.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raj.spring.jpa.postgresql.controller.TutorialController;
import com.raj.spring.jpa.postgresql.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContaining(String title);


  @Query("SELECT new map(u.id as id,u.title) FROM Tutorial u")
  List<?> findByTitle1(String query);
  
}
