package com.example.Quiz.Service;

import com.example.Quiz.Model.Questions;
import com.example.Quiz.dao.QuestionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDB db;

    //response entity is for returning questions and status codes to the client
   public ResponseEntity<List<Questions>> getAllQuestions(){
       try { // try catch is not a must
           return new ResponseEntity<>(db.findAll(), HttpStatus.OK);
       } catch(Exception e) {
            e.printStackTrace();
       }
       return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> addQuestion(Questions question) {
        db.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


}

