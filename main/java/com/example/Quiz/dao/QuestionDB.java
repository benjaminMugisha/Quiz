package com.example.Quiz.dao;


import com.example.Quiz.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDB extends JpaRepository<Questions, Integer> {
    //this method doesn't need to be defined or needs a sql query you just need to show what to return and what to pass in.
    //use findBy....() as it's given by jpa:
    List<Questions> findByDifficultyLevelIgnoreCase(String lowerCase);

    @Query(value = "SELECT * FROM Questions q WHERE q.difficulty_level=:difficultyLevel ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    public List<Questions> getQuestionByDifficulty(int numQ, String difficultyLevel);
}




