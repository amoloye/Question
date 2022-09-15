package com.example.quiz_application.dto;


import com.example.quiz_application.entity.Response;
import java.util.List;

public class QuestionDto {
    private long questionId;
    private String topic;
    private String difficultyLevel;
    private String content;
    private List<String> response;

}
