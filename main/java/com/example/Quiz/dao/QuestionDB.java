package com.example.Quiz.dao;


import com.example.Quiz.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDB extends JpaRepository<Questions, Integer> {
}




