package com.example.Quiz.Controller;

import com.example.Quiz.Model.Questions;
import com.example.Quiz.Service.QuestionService;
import com.example.Quiz.dao.QuestionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rq")
public class QuestionController {
    @Autowired
    private QuestionService qs;

    //getting the list of questions
    @GetMapping("get")
    public List<Questions> getQuestions() {
        return qs.getQues();
    }

    //search by a variable say difficulty level
    @GetMapping("diff/{difficultyLevel}")
    public List<Questions> findByDifficultyLevel(@PathVariable String difficultyLevel) {
        return qs.getDifficulty(difficultyLevel);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Questions q){
        return qs.addQuestion(q);
    }
}

