package com.example.Quiz.Controller;

import com.example.Quiz.Model.Questions;
import com.example.Quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //add a question to the db
    @PostMapping("/add")
    public void addQuestions(Questions q) {
        qs.addQuestion(q);
    }
}

