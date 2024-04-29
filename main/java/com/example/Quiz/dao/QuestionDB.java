package com.example.Quiz.dao;


import com.example.Quiz.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDB extends JpaRepository<Questions, Integer> {
    List<Questions> findByDifficultyLevelIgnoreCase(String lowerCase);
    //this method doesn't need to be defined or needs a sql query you just need to show what to return and what to pass in.
    //use findBy....() as it's given by jpa
}




