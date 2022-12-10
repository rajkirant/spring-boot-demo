package com.raj.spring.jpa.postgresql.controller;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raj.spring.jpa.postgresql.model.Tutorial;
import com.raj.spring.jpa.postgresql.repository.TutorialRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
@Slf4j
public class TutorialController {
	public static String abc = "SELECT new map(u.id as id,u.title) FROM Tutorial u";
	@Autowired
	TutorialRepository tutorialRepository;
	
	@Autowired
	EntityManager entityManager;
	


	@GetMapping("/jpql")
	public Object getAllTutorials(@RequestBody(required = false) String query) {
		TypedQuery<List<?>> o =(TypedQuery<List<?>>) entityManager.createQuery(query);
		return o.getResultList();
	}

	/*
	 * @GetMapping("/tutorials/{id}") public ResponseEntity<Tutorial>
	 * getTutorialById(@PathVariable("id") long id) { Optional<Tutorial>
	 * tutorialData = tutorialRepository.findById(id);
	 * 
	 * if (tutorialData.isPresent()) { return new
	 * ResponseEntity<>(tutorialData.get(), HttpStatus.OK); } else { return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */

	
	  @PostMapping("/tutorials") public Tutorial
	  createTutorial(@RequestBody Tutorial tutorial) { 
		  Tutorial t1 = new Tutorial();
		  t1.setDescription("t1");
		  List<Tutorial> l1 = new ArrayList<Tutorial>();
		  l1.add(t1);
		  l1.add(tutorial);
		  tutorialRepository.saveAll(l1);
		  return null;
	}
	 /*
	 * @PutMapping("/tutorials/{id}") public ResponseEntity<Tutorial>
	 * updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
	 * Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
	 * 
	 * if (tutorialData.isPresent()) { Tutorial _tutorial = tutorialData.get();
	 * _tutorial.setTitle(tutorial.getTitle());
	 * _tutorial.setDescription(tutorial.getDescription());
	 * _tutorial.setPublished(tutorial.isPublished()); return new
	 * ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK); } else {
	 * return new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 * 
	 * @DeleteMapping("/tutorials/{id}") public ResponseEntity<HttpStatus>
	 * deleteTutorial(@PathVariable("id") long id) { try {
	 * tutorialRepository.deleteById(id); return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); } catch (Exception e) { return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 * 
	 * @DeleteMapping("/tutorials") public ResponseEntity<HttpStatus>
	 * deleteAllTutorials() { try { tutorialRepository.deleteAll(); return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); } catch (Exception e) { return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * }
	 * 
	 * @GetMapping("/tutorials/published") public ResponseEntity<List<Tutorial>>
	 * findByPublished() { try { List<Tutorial> tutorials =
	 * tutorialRepository.findByPublished(true);
	 * 
	 * if (tutorials.isEmpty()) { return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); } return new
	 * ResponseEntity<>(tutorials, HttpStatus.OK); } catch (Exception e) { return
	 * new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

}
