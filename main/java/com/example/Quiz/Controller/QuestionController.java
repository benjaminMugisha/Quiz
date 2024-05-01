package com.example.Quiz.Controller;

import com.example.Quiz.Model.Questions;
import com.example.Quiz.Service.QuestionService;
import com.example.Quiz.dao.QuestionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rq")
public class QuestionController {
    @Autowired
    private QuestionService qs;

    @GetMapping("/getAllQuestions")
  public ResponseEntity<List<Questions>> getAllQuestions(){
      return qs.getAllQuestions();
  }
   @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions q){
       return qs.addQuestion(q);
   }
}

