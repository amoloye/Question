package com.example.quiz_application.service;

import com.example.quiz_application.dto.QuestionDto;
import com.example.quiz_application.entity.Question;
import com.example.quiz_application.exception.QuestionNotFoundException;
import org.springframework.stereotype.Service;


public interface QuestionService {
    Question createQuestion (QuestionDto questionDto);

    Question getQuestionById (QuestionDto questionDto) throws QuestionNotFoundException;

    Question getQuestionByTopic (QuestionDto questionDto) throws QuestionNotFoundException;

    void deleteQuestionById (QuestionDto questionDto);

    Question updateQuestion (QuestionDto questionDto);
}
