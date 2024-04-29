package com.example.Quiz.Service;

import com.example.Quiz.Model.Questions;
import com.example.Quiz.dao.QuestionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDB db;

    //to fetch
    public List<Questions> getQues(){
        return db.findAll();
    }

    //to add a question. use.saveAll() to add a list
    public void addQuestion(Questions q){
        db.save(q);
    }
}

