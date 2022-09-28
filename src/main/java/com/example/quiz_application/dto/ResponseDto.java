package com.example.quiz_application.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {
    private long responseId;
    private String text;
    private boolean correct;
    @JsonIgnore
    private QuestionDto question;
}
