package com.example.Quiz.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
//@Table(name = "questions")
@Data
public class Questions {

    @Id
    // @Column(name = "id") //not necessary but gives you more control of your column and to add some settings on columns
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;

    public Questions() {
    }

    public Questions(Integer id, String questionTitle, String option1, String option2, String option3, String option4, String rightAnswer, String difficultyLevel) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAnswer = rightAnswer;
        this.difficultyLevel = difficultyLevel;
    }
}
