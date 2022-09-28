package com.example.quiz_application.service;

import com.example.quiz_application.dto.QuestionDto;
import com.example.quiz_application.entity.Question;
import com.example.quiz_application.exception.QuestionNotFoundException;


import java.util.List;


public interface QuestionService {

    Question getQuestionById (Long questionId) throws QuestionNotFoundException;

    Question getQuestionByTopic (String topic) throws QuestionNotFoundException;

    void deleteQuestionById (Long questionId);

    Question updateQuestion (QuestionDto questionDto);

    List<Question> createQuestionList (List<QuestionDto> questionDtoList);
}
