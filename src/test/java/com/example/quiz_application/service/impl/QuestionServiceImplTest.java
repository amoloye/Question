package com.example.quiz_application.service.impl;


import com.example.quiz_application.entity.DifficultyLevel;
import com.example.quiz_application.entity.Question;
import com.example.quiz_application.entity.Response;
import com.example.quiz_application.exception.QuestionNotFoundException;
import com.example.quiz_application.repository.QuestionRepository;
import com.example.quiz_application.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class QuestionServiceImplTest {

    @Autowired
    QuestionService questionService;

    @MockBean
    QuestionRepository questionRepository;


    @BeforeEach
    public void setUp () {
        Question question = Question.builder()
                .questionId(1L)
                .content("This is my question")
                .difficultyLevel(DifficultyLevel.MEDIUM)
                .topic("PHYSICS")
                .responses(Arrays.asList(
                        Response.builder()
                                .correct(true)
                                .text("This is my answer")
                                .build(),
                        Response.builder()
                                .correct(false)
                                .text("The real answer")
                                .build()
                ))
                .build();

        List<Question> questionList = new ArrayList<>();
        questionList.add(question);
        questionRepository.saveAll(questionList);

        Mockito.when(questionRepository.findByQuestionId(1L))
                .thenReturn(java.util.Optional.ofNullable(question));

    }



    @Test
    void getQuestionById () throws QuestionNotFoundException {

        long questionId =1L;
        Question found= questionService.getQuestionById(questionId);
        assertEquals(questionId,found.getQuestionId());
    }

//
//    @Test
//    void getQuestionByTopic () {
//    }
//
//    @Test
//    void deleteQuestionById () {
//    }
//
//    @Test
//    void updateQuestion () {
//    }
//

}