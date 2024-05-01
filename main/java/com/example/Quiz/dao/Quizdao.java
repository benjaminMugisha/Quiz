package com.example.Quiz.dao;


import com.example.Quiz.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Quizdao extends JpaRepository<Quiz, Integer>{

}
