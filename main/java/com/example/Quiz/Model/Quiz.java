package com.example.Quiz.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    @ManyToMany //because we have a quiz with multiple questions and a question can belong to multiple quizes
    private List<Questions> questions;//cause a quiz can have multiple questions
}
