package com.example.quiz_application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class QuestionDto {
    private long questionId;
    private String topic;
    private String difficultyLevel;
    private String content;
    @JsonIgnore
    private List<ResponseDto> responses;

}
