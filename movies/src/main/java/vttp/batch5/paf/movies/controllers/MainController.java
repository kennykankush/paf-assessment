package vttp.batch5.paf.movies.controllers;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vttp.batch5.paf.movies.repositories.MongoMovieRepository;


@Controller
public class MainController {

  @Autowired
  private MongoMovieRepository mongoRepo;

  // TODO: Task 3
  @GetMapping("/api/summary?count={number}")
  public ResponseEntity<Object> getDirector(@PathVariable int number) {
    List<Document> directors = mongoRepo.getProlificDirectors(number);

    return ResponseEntity.ok().body(directors);
    

  }
  
   

  
  // TODO: Task 4


}
