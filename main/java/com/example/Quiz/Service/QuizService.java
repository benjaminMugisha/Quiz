package com.example.Quiz.Service;

import com.example.Quiz.Model.QuestionWrapper;
import com.example.Quiz.Model.Questions;
import com.example.Quiz.Model.Quiz;
import com.example.Quiz.dao.QuestionDB;
import com.example.Quiz.dao.Quizdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuestionDB qb;

    @Autowired
    Quizdao qz;

    // this method is for creating a quiz:
    public ResponseEntity<String> createQ(int numQ, String title, String difficultyLevel) {
        try {
            //this qs returns a list with a number of how many questions we want and difficulty level.
            List<Questions> questions = qb.getQuestionByDifficulty(numQ, difficultyLevel);

            Quiz quiz = new Quiz(); // we don't need setId() as its auto generated
            quiz.setTitle(title);//title coming from here
            quiz.setQuestions(questions);
            qz.save(quiz);

            return new ResponseEntity<>("quiz created", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("post method not working ", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
       Optional<Quiz> quiz = qz.findById(id); //findById might return null
       List<Questions> questionsFromDB = quiz.get().getQuestions(); // next turn this into question wrapper in an iteration
       List<QuestionWrapper> questionsForStudent = new ArrayList<>();
       for(Questions q: questionsFromDB){
           QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
           questionsForStudent.add(qw);
       }

      return new ResponseEntity<>(questionsForStudent, HttpStatus.OK);
    }
}
