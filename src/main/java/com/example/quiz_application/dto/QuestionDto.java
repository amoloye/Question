package com.example.quiz_application.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class QuestionDto {
    private long questionId;
    private String topic;
    private String difficultyLevel;
    private String content;
    private Map<Boolean,String> responses;

}
