package com.example.Quiz.Controller;

import com.example.Quiz.Model.QuestionWrapper;
import com.example.Quiz.Model.Response;
import com.example.Quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService qs;
    @PostMapping("create")
    //request param is to receive url variables
    public ResponseEntity<String> createQuiz(@RequestParam int numQ, @RequestParam String title, @RequestParam String difficultyLevel) {
       return qs.createQ(numQ, title, difficultyLevel);
    }

    @GetMapping("get/{id}") //use @PathVariable everytime you use a variable
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
      return qs.getQuiz(id);
    }

    //calculating the student's score based on their answers
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> calculateScore(@PathVariable Integer id, @RequestBody List<Response> responses) {
       return qs.calculateAnswer(id, responses);
    }
}
